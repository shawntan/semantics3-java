/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.semantics3.api.model;

import com.google.api.client.util.Key;
import java.util.List;


public abstract class Response<T extends Sem3Object> extends Sem3Object {

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
  
  
  
  /*
    "total_results_count": 100000,
  "code": "OK",
  "offset": 0,
  "results_count": 10,
  "results": [
  
  */  
}
