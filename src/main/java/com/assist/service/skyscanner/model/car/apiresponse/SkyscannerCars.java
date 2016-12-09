package com.assist.service.skyscanner.model.car.apiresponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by rnellaiappan on 12/9/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyscannerCars {
  
  Double price_all_days;
  Integer seats;
  String vehicle;
  SkyscannerCarLocation location;

  public Double getPrice_all_days() {
    return price_all_days;
  }

  public void setPrice_all_days(Double price_all_days) {
    this.price_all_days = price_all_days;
  }

  public Integer getSeats() {
    return seats;
  }

  public void setSeats(Integer seats) {
    this.seats = seats;
  }

  public String getVehicle() {
    return vehicle;
  }

  public void setVehicle(String vehicle) {
    this.vehicle = vehicle;
  }

  public SkyscannerCarLocation getLocation() {
    return location;
  }

  public void setLocation(SkyscannerCarLocation location) {
    this.location = location;
  }
}
