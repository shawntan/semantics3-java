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
package com.semantics3.api;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Base class for all endpoint urls.
 *
 * @author jeremy
 */
public abstract class Semantics3Url extends GenericUrl {

  final JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
  final String endpoint;

  /**
   * Method is used to return the endpoint for the current url.
   *
   * @return the endpoint for the current url.
   */
  public String getEndpoint() {
    return endpoint;
  }

  public Semantics3Url(String endpoint) {
    this("api.semantics3.com", endpoint);
  }

  public Semantics3Url(String host, String endpoint) {
    setScheme("https");
    setHost(host);
    setRawPath(new File("/v1", endpoint).getAbsolutePath());
    this.endpoint = endpoint;
  }

  Map map = new LinkedHashMap();

  String getQuery() {
    try {
      return jsonFactory.toString(map);
    } catch (IOException ex) {
      return null;
    }
  }

  /**
   * Method is used to add filtr criteria to the query. This assumes an equals
   * operator.
   *
   * @param field Field to filtr on
   * @param value Value to filtr with.
   * @return The current object to allow chaining.
   */
  public Semantics3Url filter(String field, Object value) {
    return filter(field, Operator.equ, value);
  }

  /**
   * Method is used to add filtr criteria to the query.
   *
   * @param field Field to filtr on
   * @param operator operator to filtr with.
   * @param value Value to filtr with.
   * @return The current object to allow chaining.
   */
  public Semantics3Url filter(String field, Operator operator, Object value) {
    Object v;

    if (Operator.equ == operator) {
      v = value;
    } else {
      Map m = map.get(field) == null ? new LinkedHashMap() : (Map) map.get(field);
      m.put(operator.toString(), value);
      v = m;
    }

    map.put(field, v);
    this.put("q", getQuery());
    return this;
  }

  /**
   * Method is used to remove a field from the query.
   *
   * @param field Field to filtr remove
   * @return The current object to allow chaining.
   */
  public Semantics3Url remove(String field) {
    map.remove(field);
    this.put("q", getQuery());
    return this;
  }

  public enum Operator {

    /**
     * Equals
     */
    equ,
    /**
     * Less Than
     */
    lt,
    /**
     * Greater Than
     */
    gte
  }
}
