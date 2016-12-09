package com.assist.service.skyscanner.model.hotel.apiresponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by sindhya on 12/9/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyscannerResponse {
  
  List<SkyscannerHotelPrice> hotels_prices;
  List<SkyscannerHotel> hotels;

  public List<SkyscannerHotelPrice> getHotels_prices() {
    return hotels_prices;
  }

  public void setHotels_prices(List<SkyscannerHotelPrice> hotels_prices) {
    this.hotels_prices = hotels_prices;
  }

  public List<SkyscannerHotel> getHotels() {
    return hotels;
  }

  public void setHotels(List<SkyscannerHotel> hotels) {
    this.hotels = hotels;
  }
}
