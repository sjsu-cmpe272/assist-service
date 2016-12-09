package com.assist.service.skyscanner.model.hotel.response;

import java.util.List;

/**
 * Created by sindhya on 12/9/16.
 */
public class HotelsResponse {
  
  private List<Hotel> hotels;

  public List<Hotel> getHotels() {
    return hotels;
  }

  public void setHotels(List<Hotel> hotels) {
    this.hotels = hotels;
  }
}
