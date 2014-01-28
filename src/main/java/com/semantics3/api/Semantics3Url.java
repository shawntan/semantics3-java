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
   * Method is used to add filter criteria to the query. This assumes an equals operator.
   * @param field Field to filter on
   * @param value Value to filter with.
   * @return The current object to allow chaining.
   */
  public Semantics3Url filter(String field, Object value) {
    return filter(field, Operator.equ, value);
  }

  /**
   * Method is used to add filter criteria to the query.
   * @param field Field to filter on
   * @param operator operator to filter with.
   * @param value Value to filter with.
   * @return The current object to allow chaining.
   */
  public Semantics3Url filter(String field, Operator operator, Object value) {
    Object v;

    if (Operator.equ == operator) {
      v = value;
    } else {
      Map m = new LinkedHashMap();
      m.put(operator.toString(), value);
      v = m;
    }

    map.put(field, v);
    this.put("q", getQuery());
    return this;
  }

  /**
   * Method is used to remove a field from the query.
   * @param field Field to filter remove
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
    lte,
    /**
     * Greater Than
     */
    gt
  }
}
