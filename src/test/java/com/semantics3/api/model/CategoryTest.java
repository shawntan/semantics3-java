package com.semantics3.api.model;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jeremy
 */
public class CategoryTest extends Semantics3ObjectTest<Category> {

  @Override
  protected Category create() {
    return new Category();
  }

  @Test
  public void categoryFromJson() throws IOException {
    sem3Object = fromResource("Category.json", Category.class);

    Assert.assertEquals("cat_id should be the same", "16055", sem3Object.catID);
    Assert.assertEquals("name should be the same", "Accessories & Supplies", sem3Object.name);
    Assert.assertEquals("parent_cat_id should be the same", "13658", sem3Object.parentCatID);
    Assert.assertEquals("parent_name should be the same", "Electronics", sem3Object.parentName);
  }
}
