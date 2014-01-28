package com.semantics3.api.model;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jeremy
 */
public class OfferTest extends Semantics3ObjectTest<Offer> {

  @Override
  protected Offer create() {
    return new Offer();
  }

  @Test
  public void offerFromJson() throws IOException {
    sem3Object = fromResource("Offer.json", Offer.class);

    Assert.assertEquals("seller should be the same", "LSC Warehouse", sem3Object.seller);
    Assert.assertEquals("currency should be the same", "USD", sem3Object.currency);
    Assert.assertEquals("availability should be the same", "Available", (Object) sem3Object.availability);
    Assert.assertEquals("price should be the same", "248.95", sem3Object.price);
    Assert.assertEquals("id should be the same", "6PFyDfn1qigcuqqSommeY8", sem3Object.id);
  }
}
