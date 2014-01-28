package com.semantics3.api.model;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jeremy
 */
public class OfferResponseTest extends Semantics3ObjectTest<OfferResponse> {

  @Override
  protected OfferResponse create() {
    return new OfferResponse();
  }

  @Test
  public void productResponseFromJson() throws IOException {
    sem3Object = fromResource("OfferResponse.json", OfferResponse.class);
    Assert.assertEquals("total_results_count should be the same", (Object) 5, sem3Object.totalResultsCount);
    Assert.assertEquals("code should be the same", "OK", sem3Object.code);
    Assert.assertEquals("offset should be the same", (Object) 0, sem3Object.offset);
    Assert.assertEquals("results_count should be the same", (Object) 5, sem3Object.resultsCount);
    Assert.assertNotNull("Results should not be null.", sem3Object.results);
    Assert.assertEquals("Results.size should be the same", (Object) 5, sem3Object.results.size());
  }
}
