package com.assist.service.skyscanner.model.hotel.apiresponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sindhya on 12/9/16.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyscannerHotel {
  
  private String name;
  private String hotel_id;
  private Double star_rating;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHotel_id() {
    return hotel_id;
  }

  public void setHotel_id(String hotel_id) {
    this.hotel_id = hotel_id;
  }

  public Double getStar_rating() {
    return star_rating;
  }

  public void setStar_rating(Double star_rating) {
    this.star_rating = star_rating;
  }
}
