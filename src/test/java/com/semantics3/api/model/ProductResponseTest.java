package com.semantics3.api.model;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jeremy
 */
public class ProductResponseTest extends Semantics3ObjectTest<ProductResponse> {

  @Override
  protected ProductResponse create() {
    return new ProductResponse();
  }

  @Test
  public void productResponseFromJson() throws IOException {
    sem3Object = fromResource("ProductResponse.json", ProductResponse.class);
    Assert.assertEquals("total_results_count should be the same", (Object)100000, sem3Object.totalResultsCount);
        Assert.assertEquals("code should be the same", "OK", sem3Object.code);
    Assert.assertEquals("offset should be the same", (Object)0, sem3Object.offset);
    Assert.assertEquals("results_count should be the same", (Object)10, sem3Object.resultsCount);
    Assert.assertNotNull("Results should not be null.", sem3Object.results);
    Assert.assertEquals("Results.size should be the same", (Object)10, sem3Object.results.size());
  }
}
