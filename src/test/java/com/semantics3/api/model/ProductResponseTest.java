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
public class ProductResponseTest extends Sem3ObjectTest<ProductResponse> {

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


    
    
//    Assert.assertEquals("cat_id should be the same", "13658", sem3Object.catID);
//    Assert.assertEquals("offers_total should be the same", (Object) 1, (Object) sem3Object.offersTotal);
//    Assert.assertEquals("category should be the same", "Electronics", (Object) sem3Object.category);
//    Assert.assertEquals("name should be the same", "Yamaha ATS-1520 Soundbar with Dual Built-In Subwoofers", sem3Object.name);
//    Assert.assertEquals("description should be the same", "47 1/4\" Wide - Bluetooth wireless music streaming ... (visit site URLs for full description)", sem3Object.description);
//    Assert.assertEquals("price should be the same", "248.95", sem3Object.price);
//    Assert.assertEquals("brand should be the same", "Yamaha", sem3Object.brand);
//    Assert.assertEquals("sem3_id should be the same", "5unuOoWNXsYWEWckaOoaCE", sem3Object.sem3ID);
  }
}
