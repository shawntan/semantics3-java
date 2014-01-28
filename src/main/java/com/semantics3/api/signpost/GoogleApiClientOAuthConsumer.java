package com.semantics3.api.signpost;

import oauth.signpost.AbstractOAuthConsumer;
import oauth.signpost.http.HttpRequest;

/**
 *
 * @author jeremy
 */
public class GoogleApiClientOAuthConsumer extends AbstractOAuthConsumer {

  public GoogleApiClientOAuthConsumer(String consumerKey, String consumerSecret) {
    super(consumerKey, consumerSecret);
  }

  @Override
  protected HttpRequest wrap(Object request) {
    return new HttpRequestAdapter((com.google.api.client.http.HttpRequest) request);
  }

}
