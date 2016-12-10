package com.assist.service.skyscanner.model.suggest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by sindhya on 12/9/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SkyscannerScanResponse {
  List<SkyscannerObj> results;

  public List<SkyscannerObj> getResults() {
    return results;
  }

  public void setResults(List<SkyscannerObj> results) {
    this.results = results;
  }
}
