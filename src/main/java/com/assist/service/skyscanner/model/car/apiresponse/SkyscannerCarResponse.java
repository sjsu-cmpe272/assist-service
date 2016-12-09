package com.assist.service.skyscanner.model.car.apiresponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by sindhya on 12/9/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyscannerCarResponse {
  List<SkyscannerCars> cars;

  public List<SkyscannerCars> getCars() {
    return cars;
  }

  public void setCars(List<SkyscannerCars> cars) {
    this.cars = cars;
  }
}
