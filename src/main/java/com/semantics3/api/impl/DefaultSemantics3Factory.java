/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.semantics3.api.impl;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.semantics3.api.Semantics3;
import com.semantics3.api.Semantics3Factory;
import com.semantics3.api.metrics.MetricsCollector;
import com.semantics3.api.metrics.NullMetricsCollector;

/**
 *
 * @author jeremy
 */
public class DefaultSemantics3Factory implements Semantics3Factory {

  String apiKey;
  String apiSecret;
  HttpTransport httpTransport;
  boolean exponentialBackOff;
  MetricsCollector metricsCollector;
  
  public DefaultSemantics3Factory() {
    this.httpTransport = new NetHttpTransport();
    this.exponentialBackOff = false;
    this.metricsCollector = new NullMetricsCollector();
  }

  public DefaultSemantics3Factory(String apiKey, String apiSecret) {
    this();
    this.apiKey = apiKey;
    this.apiSecret = apiSecret;
  }

  public Semantics3 create() {

    return new Semantics3Impl(apiKey, apiSecret, httpTransport, exponentialBackOff, metricsCollector);
  }

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public String getApiSecret() {
    return apiSecret;
  }

  public void setApiSecret(String apiSecret) {
    this.apiSecret = apiSecret;
  }

  public HttpTransport getHttpTransport() {
    return httpTransport;
  }

  public void setHttpTransport(HttpTransport httpTransport) {
    this.httpTransport = httpTransport;
  }

}
