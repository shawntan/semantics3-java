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
