package com.semantics3.api;

import com.semantics3.api.model.Category;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jeremy
 */
public class CategoryUrlTest extends Semantics3UrlTest<CategoryUrl> {

  @Override
  protected String getBaseUrl() {
    return "https://api.semantics3.com/v1/categories";
  }

  @Override
  protected CategoryUrl createUrl() {
    return new CategoryUrl();
  }

  @Test
  public void computers() {
    final String expected = "https://api.semantics3.com/v1/categories?q={\"name\":\"computers\"}";
    url.filter(Category.NAME, "computers");
    assertUrl(expected);
  } 
}
