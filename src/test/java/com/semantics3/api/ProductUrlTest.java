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
    url
            .filter(Product.CAT_ID, 4992)
            .filter(Product.BRAND, "Toshiba");
    assertUrl(expected);
  }  
  
  @Test
  public void queryMultiple(){
    final String expected = "https://api.semantics3.com/v1/products?q={\"cat_id\":4992,\"brand\":\"Toshiba\",\"weight\":{\"gte\":1000000,\"lt\":1500000}}";
    url
            .filter(Product.CAT_ID, 4992)
            .filter(Product.BRAND, "Toshiba")
            .filter(Product.WEIGHT, Semantics3Url.Operator.gte, 1000000)
            .filter(Product.WEIGHT, Semantics3Url.Operator.lt, 1500000)
    ;
    
    assertUrl(expected);
    
  }
  
  
//    @Test
  public void nestedSearchQuery(){
    final String expected = "https://api.semantics3.com/v1/products?q={\"cat_id\":4992,\"brand\":\"Toshiba\",\"weight\":{\"gte\":1000000,\"lt\":1500000},\"sitedetails\":{\"name\":\"newegg.com\",\"latestoffers\":{\"currency\":\"USD\",\"price\":{\"gte\":100}}}}";
    url
            .filter(Product.CAT_ID, 4992)
            .filter(Product.BRAND, "Toshiba")
            .filter(Product.WEIGHT, Semantics3Url.Operator.gte, 1000000)
            .filter(Product.WEIGHT, Semantics3Url.Operator.lt, 1500000)
    ;
    
    assertUrl(expected);
    
  }
}
