package com.semantics3.api;

/**
 *
 * @author jeremy
 */
public class OfferUrl extends Semantics3Url {

  public OfferUrl(String host) {
    super(host, "offers");
  }

  public OfferUrl() {
    super("offers");
  }
}
