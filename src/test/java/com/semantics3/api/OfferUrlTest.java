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

import com.semantics3.api.model.Offer;
import com.semantics3.api.model.Product;
import org.junit.Test;

/**
 *
 * @author jeremy
 */
public class OfferUrlTest extends Semantics3UrlTest<OfferUrl> {

  @Override
  protected String getBaseUrl() {
    return "https://api.semantics3.com/v1/offers";
  }

  @Override
  protected OfferUrl createUrl() {
    return new OfferUrl();
  }

  @Test
  public void sem3id() {
    final String expected = "https://api.semantics3.com/v1/offers?q={\"sem3_id\":\"5unuOoWNXsYWEWckaOoaCE\"}";
    url.filter(Product.SEM3_ID, "5unuOoWNXsYWEWckaOoaCE");
    assertUrl(expected);
  }

  @Test
  public void offersByFrysAmazon() {
    final String expected = "https://api.semantics3.com/v1/offers?q={\"sem3_id\":\"5unuOoWNXsYWEWckaOoaCE\",\"sitedetails_name\":[\"frys.com\",\"amazon.com\"]}";

    url.filter(Product.SEM3_ID, "5unuOoWNXsYWEWckaOoaCE");
    url.filter(Offer.SITEDETAILS_NAME, new String[]{"frys.com", "amazon.com"});
    
    assertUrl(expected);
  }  
}
