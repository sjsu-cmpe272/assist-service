package com.assist.service.skyscanner.domain;

import com.google.gson.Gson;

import com.assist.service.skyscanner.SkyscannerConstants;
import com.assist.service.skyscanner.model.hotel.apiresponse.SkyscannerHotel;
import com.assist.service.skyscanner.model.hotel.apiresponse.SkyscannerHotelPrice;
import com.assist.service.skyscanner.model.hotel.apiresponse.SkyscannerResponse;
import com.assist.service.skyscanner.model.hotel.request.HotelsRequest;
import com.assist.service.skyscanner.model.hotel.response.Hotel;
import com.assist.service.skyscanner.model.hotel.response.HotelsResponse;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sindhya on 12/9/16.
 */
public class SkyscannerHotelService {
  
  /*
  http://partners.api.skyscanner.net/apiservices/hotels
  /autosuggest/v2/US/USD/en-US/portland?apikey=prtl6749387986743898559646983194
   */
  private static String url = "http://partners.api.skyscanner.net/apiservices/hotels/liveprices/v2/US/USD/en-US/";

  private static HttpClient client = new DefaultHttpClient();
  // 27539733/2016-12-16/2016-12-23/2/1
  
  public static HotelsResponse callSkyscannerService (HotelsRequest skyscannerRequest) throws Exception{
    String final_url = createUrl(skyscannerRequest);
    
    HttpGet request = new HttpGet(final_url);
    request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
    HttpResponse response = client.execute(request);
    BufferedReader rd = new BufferedReader(
        new InputStreamReader(response.getEntity().getContent()));

    StringBuffer result = new StringBuffer();
    String line = "";
    while ((line = rd.readLine()) != null) {
      result.append(line);
    }
    SkyscannerResponse info = new Gson().fromJson(result.toString(), SkyscannerResponse.class);
    
    return mapHotelsResponse(info);
  }

  
  
  private static String createUrl(HotelsRequest skyscannerRequest){
    
    
    StringBuilder sb = new StringBuilder();
    sb.append(url);
    if (!StringUtils.isEmpty(skyscannerRequest.getLocation())) {
      sb.append(skyscannerRequest.getLocation());
    }
    else {
      sb.append("35248814");
    }
    sb.append("/");
    
    
    if (!StringUtils.isEmpty(skyscannerRequest.getFromDate())) {
      sb.append(skyscannerRequest.getFromDate());
    }
    else {
      //TODO: Append today string
      sb.append("");
    }
    sb.append("/");


    if (!StringUtils.isEmpty(skyscannerRequest.getToDate())) {
      sb.append(skyscannerRequest.getToDate());
    }
    else {
      //TODO: Append two days from today string
      sb.append("");
    }
    sb.append("/");

    if (!StringUtils.isEmpty(skyscannerRequest.getOccupancy())) {
      sb.append(skyscannerRequest.getOccupancy());
    }
    else {
      sb.append("2");
    }
    sb.append("/");


    if (!StringUtils.isEmpty(skyscannerRequest.getRooms())) {
      sb.append(skyscannerRequest.getRooms());
    }
    else {
      sb.append("1");
    }
    sb.append("?");
    sb.append("apiKey=");
    sb.append(SkyscannerConstants.api_key);
    return sb.toString();
  }
  
  
  public static HotelsResponse mapHotelsResponse(SkyscannerResponse info){
    
    if (info == null)
      return null;
    List<SkyscannerHotelPrice> hotelPrices = info.getHotels_prices();
    List<SkyscannerHotel> hotels = info.getHotels();
    Map<String, Hotel> hotelMap = new HashMap<>();
    if (!CollectionUtils.isEmpty(hotels)){
      for (SkyscannerHotel eachHotel:hotels){
        Hotel hotel = new Hotel();
        hotel.setName(eachHotel.getName());
        hotel.setHotelId(eachHotel.getHotel_id());
        hotel.setStarRating(eachHotel.getStar_rating());
        hotelMap.put(hotel.getHotelId(),hotel);
      }
    }
    if (!CollectionUtils.isEmpty(hotelPrices)){
      for (SkyscannerHotelPrice eachHP: hotelPrices){
        Hotel h = hotelMap.get(eachHP.getId());
        if (h!=null && eachHP.getAgent_prices()!=null && eachHP.getAgent_prices().size()>0){
          h.setPrice(eachHP.getAgent_prices().get(0).getPrice_total());
        }
      }
    }
    HotelsResponse response = new HotelsResponse();
    response.setHotels(new ArrayList<>(hotelMap.values()));
    return response;
    
  }
  
}
