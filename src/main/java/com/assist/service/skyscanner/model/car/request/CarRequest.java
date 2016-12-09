package com.assist.service.skyscanner.model.car.request;

/**
 * Created by sindhya on 12/9/16.
 */
public class CarRequest {
  
  private String pickupDropoff;
  private String pickupDateTime;
  private String dropOffDateTime;
  private String driverAge;

  public String getPickupDropoff() {
    return pickupDropoff;
  }

  public void setPickupDropoff(String pickupDropoff) {
    this.pickupDropoff = pickupDropoff;
  }

  public String getPickupDateTime() {
    return pickupDateTime;
  }

  public void setPickupDateTime(String pickupDateTime) {
    this.pickupDateTime = pickupDateTime;
  }

  public String getDropOffDateTime() {
    return dropOffDateTime;
  }

  public void setDropOffDateTime(String dropOffDateTime) {
    this.dropOffDateTime = dropOffDateTime;
  }

  public String getDriverAge() {
    return driverAge;
  }

  public void setDriverAge(String driverAge) {
    this.driverAge = driverAge;
  }
}
