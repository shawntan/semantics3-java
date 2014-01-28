package com.semantics3.api;

/**
 *
 * @author jeremy
 */
public class ProductUrl extends Semantics3Url {

  public ProductUrl(String host) {
    super(host, "products");
  }

  public ProductUrl() {
    super("products");
  }
}
