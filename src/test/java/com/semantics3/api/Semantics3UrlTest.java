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
