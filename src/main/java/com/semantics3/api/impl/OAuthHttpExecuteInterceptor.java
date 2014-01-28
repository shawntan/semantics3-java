/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.semantics3.api.impl;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

/**
 *
 * @author jeremy
 */
class OAuthHttpExecuteInterceptor implements HttpExecuteInterceptor {

  final OAuthConsumer consumer;

  public OAuthHttpExecuteInterceptor(OAuthConsumer consumer) {
    this.consumer = consumer;
  }

  public void intercept(HttpRequest request) throws IOException {
    try {
      consumer.sign(request);
    } catch (OAuthMessageSignerException ex) {
      throw new IOException("Exception while signing request", ex);
    } catch (OAuthExpectationFailedException ex) {
      throw new IOException("Exception while signing request", ex);
    } catch (OAuthCommunicationException ex) {
      throw new IOException("Exception while signing request", ex);
    }
  }

}
