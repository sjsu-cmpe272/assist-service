package com.assist.service.skyscanner.model.hotel.response;

/**
 * Created by sindhya on 12/9/16.
 */
public class Hotel {
  
  private String name;
  private String hotelId;
  private Double starRating;
  private Double price;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHotelId() {
    return hotelId;
  }

  public void setHotelId(String hotelId) {
    this.hotelId = hotelId;
  }

  public Double getStarRating() {
    return starRating;
  }

  public void setStarRating(Double starRating) {
    this.starRating = starRating;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
