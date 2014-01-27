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
public class Offer extends Sem3Object {

  @Key("seller")
  String seller;
//  lastrecorded_at
  @Key("currency")
  String currency;
  @Key("availability")
  String availability;
  @Key("price")
  String price;
  @Key("id")
  String id;

//        {
//          "seller": "LSC Warehouse",
//          "lastrecorded_at": 1389536900,
//          "currency": "USD",
//          "firstrecorded_at": 1387071800,
//          "availability": "Available",
//          "price": "248.95",
//          "id": "6PFyDfn1qigcuqqSommeY8"
//        }  
}
