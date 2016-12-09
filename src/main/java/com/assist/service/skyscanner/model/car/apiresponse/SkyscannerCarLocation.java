package com.assist.service.skyscanner.model.car.apiresponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by rnellaiappan on 12/9/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyscannerCarLocation {
  SkyscannerCarPickup pick_up;

  public SkyscannerCarPickup getPick_up() {
    return pick_up;
  }

  public void setPick_up(SkyscannerCarPickup pick_up) {
    this.pick_up = pick_up;
  }
}
