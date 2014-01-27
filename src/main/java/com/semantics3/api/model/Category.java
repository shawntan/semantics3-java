/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.semantics3.api.model;

import com.google.api.client.util.Key;

/**
 *
 * @author jeremy
 */
public class Category extends Sem3Object{
  
  @Key("cat_id")
  String catID;
  
  @Key("name")
  String name;
  
  @Key("parent_cat_id")
  String parentCatID;

  @Key("parent_name")
  String parentName;
}
