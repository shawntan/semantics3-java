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
package com.semantics3.api.signpost;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import oauth.signpost.http.HttpRequest;

/**
 *
 * @author jeremy
 */
public class HttpRequestAdapter implements HttpRequest {

  final com.google.api.client.http.HttpRequest httpRequest;

  public HttpRequestAdapter(com.google.api.client.http.HttpRequest httpRequest) {
    this.httpRequest = httpRequest;
  }

  public String getMethod() {
    return this.httpRequest.getRequestMethod();
  }

  public String getRequestUrl() {
    return this.httpRequest.getUrl().toString();
  }

  public void setRequestUrl(String string) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public void setHeader(String key, String value) {
    if ("Authorization".equals(key)) {
      this.httpRequest.getHeaders().setAuthorization(value);
    } else {
      this.httpRequest.getHeaders().set(key, value);
    }
  }

  public String getHeader(String key) {
    return (String) this.httpRequest.getHeaders().get(key);
  }

  public Map<String, String> getAllHeaders() {
    Map<String, String> headers = new HashMap<String, String>();
    for (String key : this.httpRequest.getHeaders().keySet()) {
      String value = (String) this.httpRequest.getHeaders().get(key);
      headers.put(key, value);
    }
    return headers;
  }

  public InputStream getMessagePayload() throws IOException {
    return null;
  }

  public String getContentType() {
    return this.httpRequest.getHeaders().getContentType();
  }

  public Object unwrap() {
    return this.httpRequest;
  }

}
