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
