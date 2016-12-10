package com.assist.service.skyscanner.domain;

import com.google.gson.Gson;

import com.assist.service.skyscanner.SkyscannerConstants;
import com.assist.service.skyscanner.model.car.apiresponse.SkyscannerCarResponse;
import com.assist.service.skyscanner.model.car.request.CarRequest;
import com.assist.service.skyscanner.model.car.response.CarsResponse;
import com.assist.service.skyscanner.model.suggest.SkyscannerObj;
import com.assist.service.skyscanner.model.suggest.SkyscannerScanResponse;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.cglib.core.CollectionUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by rnellaiappan on 12/9/16.
 */
public class SkyscannerSuggestService {

  private static String url = "http://partners.api.skyscanner.net/apiservices/hotels/autosuggest/v2/US/USD/en-US/";

  private static HttpClient client = new DefaultHttpClient();
  // 27539733/2016-12-16/2016-12-23/2/1

  public static String callSkyscannerScanService (String location) {
    String final_url = createUrl(location);

    HttpGet request = new HttpGet(final_url);
    String id =null;
    request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
    try {
      HttpResponse response = client.execute(request);
      BufferedReader rd = new BufferedReader(
          new InputStreamReader(response.getEntity().getContent()));

      StringBuffer result = new StringBuffer();
      String line = "";
      while ((line = rd.readLine()) != null) {
        result.append(line);
      }
   
      SkyscannerScanResponse info = new Gson().fromJson(result.toString(), SkyscannerScanResponse.class);
      id = findIdForCity(info, location);
    }catch  (Exception e){
      e.printStackTrace();
    }
    return id;
  }
  
  
  public static String findIdForCity(SkyscannerScanResponse info, String location) {
    if (info == null)
      return null;

    String id=null;
    if (!org.springframework.util.CollectionUtils.isEmpty(info.getResults())) {
      for (SkyscannerObj eachobj : info.getResults()) {
        if ("city".equalsIgnoreCase(eachobj.getGeo_type()) && location.equalsIgnoreCase(eachobj.getDisplay_name())) {
          id = eachobj.getIndividual_id();
          break;
        }
      }
    }

    return id;
  }



  private static String createUrl(String location){
    
    return url+location+"?apikey="+ SkyscannerConstants.api_key;
    
  }
}
