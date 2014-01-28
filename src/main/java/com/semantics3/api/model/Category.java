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
package com.semantics3.api.model;

import com.google.api.client.util.Key;

public class Category extends Semantics3Object { 

  /**
  * Category ID
  */
  public static final String CAT_ID = "cat_id";
  /**
  * Name
  */
  public static final String NAME = "name";
  /**
  * parent_cat_id
  */
  public static final String PARENT_CAT_ID = "parent_cat_id";
  /**
  * parent_name
  */
  public static final String PARENT_NAME = "parent_name";

  @Key(CAT_ID)
  String catID;
  @Key(NAME)
  String name;
  @Key(PARENT_CAT_ID)
  String parentCatID;
  @Key(PARENT_NAME)
  String parentName;

  /**
  * Category ID
  * @return String
  */
  public String getCatID() {
    return this.catID;
  }
  /**
  * Name
  * @return String
  */
  public String getName() {
    return this.name;
  }
  /**
  * parent_cat_id
  * @return String
  */
  public String getParentCatID() {
    return this.parentCatID;
  }
  /**
  * parent_name
  * @return String
  */
  public String getParentName() {
    return this.parentName;
  }
}