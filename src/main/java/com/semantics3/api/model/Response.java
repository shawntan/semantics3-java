package com.semantics3.api.model;

import com.google.api.client.util.Key;
import java.util.List;

public abstract class Response<T extends Semantics3Object> extends Semantics3Object {

  @Key("total_results_count")
  Integer totalResultsCount;

  @Key("offset")
  Integer offset;

  @Key("results_count")
  Integer resultsCount;

  @Key("code")
  String code;

  @Key("results")
  List<T> results;

  public Integer getOffset() {
    return offset;
  }

  public List<T> getResults() {
    return results;
  }

  public Integer getResultsCount() {
    return resultsCount;
  }

  public Integer getTotalResultsCount() {
    return totalResultsCount;
  }

  /*
   "total_results_count": 100000,
   "code": "OK",
   "offset": 0,
   "results_count": 10,
   "results": [
  
   */
  public String getCode() {
    return code;
  }
}
