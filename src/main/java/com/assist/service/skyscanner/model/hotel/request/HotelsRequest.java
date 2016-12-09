package com.assist.service.skyscanner.model.hotel.request;

/**
 * Created by sindhya on 12/9/16.
 */
public class HotelsRequest {

  private String location;
  private String fromDate;
  private String toDate;
  private Integer occupancy;
  private Integer rooms;

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getFromDate() {
    return fromDate;
  }

  public void setFromDate(String fromDate) {
    this.fromDate = fromDate;
  }

  public String getToDate() {
    return toDate;
  }

  public void setToDate(String toDate) {
    this.toDate = toDate;
  }

  public Integer getOccupancy() {
    return occupancy;
  }

  public void setOccupancy(Integer occupancy) {
    this.occupancy = occupancy;
  }

  public Integer getRooms() {
    return rooms;
  }

  public void setRooms(Integer rooms) {
    this.rooms = rooms;
  }
}
