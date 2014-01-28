package com.semantics3.api.impl;

import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.ExponentialBackOff;
import java.io.IOException;
import oauth.signpost.OAuthConsumer;

/**
 *
 * @author jeremy
 */
class Semantics3HttpRequestInitializer implements HttpRequestInitializer {
  final JsonFactory jsonFactory;
  final boolean exponentialBackOff;
  final OAuthHttpExecuteInterceptor oAuthHttpExecuteInterceptor;
  public Semantics3HttpRequestInitializer(OAuthConsumer consumer, JsonFactory jsonFactory, boolean exponentialBackOff) {
    this.jsonFactory = jsonFactory;
    this.exponentialBackOff = exponentialBackOff;
    this.oAuthHttpExecuteInterceptor = new OAuthHttpExecuteInterceptor(consumer);
  }

  public void initialize(HttpRequest request) throws IOException {
    request.setLoggingEnabled(true);
    request.setCurlLoggingEnabled(true);
    request.setParser(jsonFactory.createJsonObjectParser());
    if (exponentialBackOff) {
      request.setUnsuccessfulResponseHandler(
              new HttpBackOffUnsuccessfulResponseHandler(new ExponentialBackOff()));
    }
    request.setInterceptor(oAuthHttpExecuteInterceptor);
  }

}
