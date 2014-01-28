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
