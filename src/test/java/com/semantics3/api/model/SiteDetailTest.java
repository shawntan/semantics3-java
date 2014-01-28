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
public class SiteDetailTest extends Semantics3ObjectTest<SiteDetail> {

  @Override
  protected SiteDetail create() {
    return new SiteDetail();
  }

  @Test
  public void siteDetailFromJson() throws IOException {
    sem3Object = fromResource("SiteDetail.json", SiteDetail.class);

    Assert.assertEquals("offers_count should be the same", (Object) 1, (Object) sem3Object.offersCount);
    Assert.assertEquals("sku should be the same", "ats-1520", sem3Object.sku);
    Assert.assertEquals("url should be the same", "http://www.lscwarehouse.com/ats-1520.html", sem3Object.url);
    Assert.assertEquals("name should be the same", "lscwarehouse.com", sem3Object.name);
    Assert.assertEquals("recentoffers_count should be the same", (Object) 1, (Object) sem3Object.recentOffersCount);
    Assert.assertNotNull("latest_offers should not be null.", sem3Object.latestOffers);
    Assert.assertEquals("offers_count and latest_offers.size should be the same", (Object) sem3Object.offersCount, (Object) sem3Object.latestOffers.size());
    
  }
}
