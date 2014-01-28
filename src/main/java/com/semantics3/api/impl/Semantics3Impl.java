package com.semantics3.api.impl;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.semantics3.api.Semantics3;
import com.semantics3.api.Semantics3Url;
import com.semantics3.api.metrics.MetricsCollector;
import com.semantics3.api.model.Semantics3Object;
import com.semantics3.api.signpost.GoogleApiClientOAuthConsumer;
import java.io.IOException;
import oauth.signpost.OAuthConsumer;

/**
 *
 * @author jeremy
 */
class Semantics3Impl implements Semantics3 {

  final String apiKey;
  final String apiSecret;
  final OAuthConsumer consumer;
  final HttpRequestFactory requestFactory;
  final JsonFactory jsonFactory;
  final MetricsCollector metricsCollector;

  public Semantics3Impl(String apiKey, String apiSecret, HttpTransport httpTransport, boolean exponentialBackOff, MetricsCollector metricsCollector) {
    this.apiKey = apiKey;
    this.apiSecret = apiSecret;
    this.consumer = new GoogleApiClientOAuthConsumer(this.apiKey, this.apiSecret);
    this.jsonFactory = JacksonFactory.getDefaultInstance();
    this.metricsCollector = metricsCollector;
    this.requestFactory = httpTransport.createRequestFactory(new Semantics3HttpRequestInitializer(consumer, jsonFactory, exponentialBackOff));
  }

  public <T extends Semantics3Object> T query(Semantics3Url url, Class<T> type) throws IOException {
    HttpRequest request = requestFactory.buildGetRequest(url);
    
    long startTime = System.currentTimeMillis();
    try {
      HttpResponse response = request.execute();
      metricsCollector.recordCallSuccess(url.getEndpoint());
      return response.parseAs(type);
    } catch(RuntimeException ex) {
      metricsCollector.recordCallFailure(url.getEndpoint());
      throw ex;
    }
      finally {
      long elapased = System.currentTimeMillis() - startTime;
      metricsCollector.recordEndPoint(url.getEndpoint(), elapased);
    }
  }

}
