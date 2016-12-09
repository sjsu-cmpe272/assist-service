package com.assist.service.skyscanner.model.car.response;

import java.util.List;

/**
 * Created by rnellaiappan on 12/9/16.
 */
public class CarsResponse {
  
  List<Cars> cars;

  public List<Cars> getCars() {
    return cars;
  }

  public void setCars(List<Cars> cars) {
    this.cars = cars;
  }
}
