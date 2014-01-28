/*
The "MIT" License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
DEALINGS IN THE SOFTWARE.
*/
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
