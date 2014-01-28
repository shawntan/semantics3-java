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
package com.semantics3.api.model;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jeremy
 */
public class ProductTest extends Semantics3ObjectTest<Product> {

  @Override
  protected Product create() {
    return new Product();
  }

  @Test
  public void productResultFromJson() throws IOException {
    sem3Object = fromResource("Product.json", Product.class);

    Assert.assertEquals("cat_id should be the same", "13658", sem3Object.catID);
    Assert.assertEquals("offers_total should be the same", (Object) 1, (Object) sem3Object.offersTotal);
    Assert.assertEquals("category should be the same", "Electronics", (Object) sem3Object.category);
    Assert.assertEquals("name should be the same", "Yamaha ATS-1520 Soundbar with Dual Built-In Subwoofers", sem3Object.name);
    Assert.assertEquals("description should be the same", "47 1/4\" Wide - Bluetooth wireless music streaming ... (visit site URLs for full description)", sem3Object.description);
    Assert.assertEquals("price should be the same", "248.95", sem3Object.price);
    Assert.assertEquals("brand should be the same", "Yamaha", sem3Object.brand);
    Assert.assertEquals("sem3_id should be the same", "5unuOoWNXsYWEWckaOoaCE", sem3Object.sem3ID);
  }
}
