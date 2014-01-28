package com.semantics3.api;

import com.semantics3.api.impl.DefaultSemantics3Factory;
import com.semantics3.api.model.ProductResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jeremy
 */
public class Semantics3Test {

  DefaultSemantics3Factory factory;
  Semantics3 semantics3;

  @Before
  public void setup() throws IOException {
    InputStream iostr = this.getClass().getClassLoader().getResourceAsStream("credentials.properties");

    if (null == iostr) {
      Assert.fail("credentials.properties was not found");
    }

    Properties properties = new Properties();
    properties.load(iostr);

    String apiKey = properties.getProperty("apiKey");
    String apiSecret = properties.getProperty("apiSecret");

    factory = new DefaultSemantics3Factory(apiKey, apiSecret);
    
    
    
    semantics3 = factory.create();

  }

  @Test
  public void test() throws IOException {
    ProductUrl url = new ProductUrl();
    url.filter("search", "Apple Macbook");
    
    ProductResponse response = semantics3.query(url, ProductResponse.class);
    Assert.assertNotNull(response);
    Assert.assertEquals("OK", response.getCode());
  }

}
