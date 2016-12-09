package com.assist.service.skyscanner.controller;

import com.assist.service.skyscanner.domain.SkyscannerCarService;
import com.assist.service.skyscanner.domain.SkyscannerHotelService;
import com.assist.service.skyscanner.model.car.request.CarRequest;
import com.assist.service.skyscanner.model.car.response.CarsResponse;
import com.assist.service.skyscanner.model.hotel.request.HotelsRequest;
import com.assist.service.skyscanner.model.hotel.response.HotelsResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sindhya on 10/31/16.
 */

@RestController
public class SkyscannerController {

  @RequestMapping(value="/hotels",method= RequestMethod.POST)
  public HotelsResponse hotels(@RequestBody HotelsRequest skyscannerRequest){
    HotelsResponse response = null;
    try {
      response = SkyscannerHotelService.callSkyscannerService(skyscannerRequest);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return response;
  }


  @RequestMapping(value="/cars",method= RequestMethod.POST)
  public CarsResponse hotels(@RequestBody CarRequest skyscannerRequest){
    CarsResponse response = null;
    try {
      response = SkyscannerCarService.callSkyscannerCarService(skyscannerRequest);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return response;
  }

}