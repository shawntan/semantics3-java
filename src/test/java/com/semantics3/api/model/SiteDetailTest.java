/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.semantics3.api.model;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jeremy
 */
public class SiteDetailTest extends Sem3ObjectTest<SiteDetail> {

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

  }
}
