package com.semantics3.api.model;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;

public abstract class Semantics3ObjectTest<T extends Semantics3Object> {

  protected JsonFactory JSON_FACTORY = new JacksonFactory();
  protected T sem3Object;

  protected abstract T create();

  protected T fromResource(String resourceName, Class<T> type) throws IOException {
    InputStream iostr = getClass().getResourceAsStream(resourceName);
    Assert.assertNotNull("inputStream not found - " + resourceName, iostr);
    String json = IOUtils.toString(iostr, "UTF-8");
    System.out.println(json);
    T result =  JSON_FACTORY.fromString(json, type);
    Assert.assertNotNull("result should not be null", result);
    return result;
  }

  @Before
  public void setup() {
    sem3Object = create();

  }

  protected void assertJson(Object object, String expectedJson) {
    try {
      String actualJson = JSON_FACTORY.toString(object);
      System.out.println(actualJson);
      Assert.assertEquals("Json should match", expectedJson, actualJson);
    } catch (IOException ex) {
      Assert.fail("Exception thrown while serializing.\n" + ex);
    }
  }
}
