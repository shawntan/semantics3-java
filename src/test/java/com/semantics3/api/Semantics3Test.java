/*
The "MIT" License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
DEALINGS IN THE SOFTWARE.
*/
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
