package com.assist.service.skyscanner.model.hotel.apiresponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by sindhya on 12/9/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyscannerHotelPrice {
  
  private String id;
  private List<SkyscannerAgentPrice> agent_prices;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<SkyscannerAgentPrice> getAgent_prices() {
    return agent_prices;
  }

  public void setAgent_prices(List<SkyscannerAgentPrice> agent_prices) {
    this.agent_prices = agent_prices;
  }
}
