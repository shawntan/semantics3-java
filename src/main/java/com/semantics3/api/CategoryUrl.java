package com.semantics3.api;

/**
 * 
 * @author jeremy
 */
public class CategoryUrl extends Semantics3Url {

  public CategoryUrl(String host) {
    super(host, "categories");
  }

  public CategoryUrl() {
    super("categories");
  }
}
