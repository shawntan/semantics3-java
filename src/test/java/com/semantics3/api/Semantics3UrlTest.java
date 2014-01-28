package com.semantics3.api;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class Semantics3UrlTest<T extends Semantics3Url> {

  protected T url;
  
  protected abstract T createUrl();

  protected abstract String getBaseUrl();
  
  @Before
  public void setupUrl() {
    url = createUrl();
  }
  
  protected void assertUrl(final String expectedUrl) {
    String encodedUrl = url.toString();
    String actualUrl;
    try {
      actualUrl = URLDecoder.decode(encodedUrl, "UTF-8");
    } catch (UnsupportedEncodingException ex) {
      throw new IllegalArgumentException("Invalid encoding selected", ex);
    }
    System.out.println(actualUrl);
    Assert.assertEquals(expectedUrl, actualUrl);
  }
  
  @Test
  public void url() {
    String expectedUrl = getBaseUrl();
    assertUrl(expectedUrl);
  }  
}
