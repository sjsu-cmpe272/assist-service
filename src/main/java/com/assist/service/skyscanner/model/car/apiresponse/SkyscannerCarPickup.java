package com.assist.service.skyscanner.model.car.apiresponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by rnellaiappan on 12/9/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyscannerCarPickup {
  
  String address;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
