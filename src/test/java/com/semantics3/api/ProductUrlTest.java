package com.semantics3.api;

import com.semantics3.api.model.Product;
import org.junit.Test;

/**
 *
 * @author jeremy
 */
public class ProductUrlTest extends Semantics3UrlTest<ProductUrl> {

  @Override
  protected String getBaseUrl() {
    return "https://api.semantics3.com/v1/products";
  }

  @Override
  protected ProductUrl createUrl() {
    return new ProductUrl();
  }

  @Test
  public void search() {
    final String expected = "https://api.semantics3.com/v1/products?q={\"search\":\"Apple Macbook\"}";
    url.filter("search", "Apple Macbook");
    assertUrl(expected);
  }

  @Test
  public void categoryAndBrand() {
    final String expected = "https://api.semantics3.com/v1/products?q={\"cat_id\":4992,\"brand\":\"Toshiba\"}";
    url.filter(Product.CAT_ID, 4992)
            .filter(Product.BRAND, "Toshiba");
    assertUrl(expected);
  }  
}
