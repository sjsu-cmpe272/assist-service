package com.assist.service.skyscanner.domain;

import com.google.gson.Gson;

import com.assist.service.skyscanner.SkyscannerConstants;
import com.assist.service.skyscanner.model.car.apiresponse.SkyscannerCarResponse;
import com.assist.service.skyscanner.model.car.apiresponse.SkyscannerCars;
import com.assist.service.skyscanner.model.car.request.CarRequest;
import com.assist.service.skyscanner.model.car.response.Cars;
import com.assist.service.skyscanner.model.car.response.CarsResponse;

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
import java.util.List;

/**
 * Created by sindhya on 12/9/16.
 */
public class SkyscannerCarService {

  /*
  http://partners.api.skyscanner.net/apiservices/hotels
  /autosuggest/v2/US/USD/en-US/portland?apikey=prtl6749387986743898559646983194
   */
  private static String url = "http://partners.api.skyscanner.net/apiservices/carhire/liveprices/v2/US/USD/en-US/";

  private static HttpClient client = new DefaultHttpClient();
  // 27539733/2016-12-16/2016-12-23/2/1

  public static CarsResponse callSkyscannerCarService (CarRequest carRequest) throws Exception{
    String final_url = createUrl(carRequest);

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
    SkyscannerCarResponse info = new Gson().fromJson(result.toString(), SkyscannerCarResponse.class);

    return mapCarsResponse(info);
  }



  private static String createUrl(CarRequest carRequest){


    StringBuilder sb = new StringBuilder();
    sb.append(url);
    //assume pick up drop same place
    if (!StringUtils.isEmpty(carRequest.getPickupDropoff())) {
      String location = SkyscannerSuggestService.callSkyscannerScanService(carRequest.getPickupDropoff());
      sb.append(location);
      sb.append("/");
      sb.append(location);
    }
    else {
      sb.append("35248814/35248814");
    }
    sb.append("/");


    if (!StringUtils.isEmpty(carRequest.getPickupDateTime())) {
      sb.append(carRequest.getPickupDateTime());
    }
    else {
      //TODO: Append today string
      sb.append("");
    }
    sb.append("/");


    if (!StringUtils.isEmpty(carRequest.getDropOffDateTime())) {
      sb.append(carRequest.getDropOffDateTime());
    }
    else {
      //TODO: Append two days from today string
      sb.append("");
    }
    sb.append("/");

    if (!StringUtils.isEmpty(carRequest.getDriverAge())) {
      sb.append(carRequest.getDriverAge());
    }
    else {
      sb.append("25");
    }
    sb.append("?");
    sb.append("apiKey=");
    sb.append(SkyscannerConstants.api_key);
    sb.append(SkyscannerConstants.user_ip);
    return sb.toString();
  }


  public static CarsResponse mapCarsResponse(SkyscannerCarResponse info){

    if (info == null)
      return null;
    List<SkyscannerCars> cars = info.getCars();
    List<Cars> responseCars = new ArrayList<>();
    if (!CollectionUtils.isEmpty(cars)){
      for (SkyscannerCars eachCar:cars){
        Cars car = new Cars();
        car.setVehicle(eachCar.getVehicle());
        car.setPrice(eachCar.getPrice_all_days());
        car.setSeat(eachCar.getSeats()==null?"":eachCar.getSeats()+" seater");
        if (eachCar.getLocation() !=null && eachCar.getLocation().getPick_up()!=null)
          car.setPickupAddress(eachCar.getLocation().getPick_up().getAddress());
        responseCars.add(car);
      }
    }
   
    CarsResponse response = new CarsResponse();
    response.setCars(responseCars);
    return response;

  }

}
