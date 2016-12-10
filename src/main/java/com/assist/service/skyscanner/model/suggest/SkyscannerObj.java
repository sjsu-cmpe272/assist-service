package com.assist.service.skyscanner.model.suggest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sindhya on 12/9/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyscannerObj {
  String display_name;
  String geo_type;
  String individual_id;

  public String getDisplay_name() {
    return display_name;
  }

  public void setDisplay_name(String display_name) {
    this.display_name = display_name;
  }

  public String getGeo_type() {
    return geo_type;
  }

  public void setGeo_type(String geo_type) {
    this.geo_type = geo_type;
  }

  public String getIndividual_id() {
    return individual_id;
  }

  public void setIndividual_id(String individual_id) {
    this.individual_id = individual_id;
  }
}
