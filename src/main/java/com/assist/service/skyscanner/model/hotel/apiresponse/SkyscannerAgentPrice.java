package com.assist.service.skyscanner.model.hotel.apiresponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sindhya on 12/9/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyscannerAgentPrice {
  
  Integer id;
  Double price_total;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Double getPrice_total() {
    return price_total;
  }

  public void setPrice_total(Double price_total) {
    this.price_total = price_total;
  }
}
