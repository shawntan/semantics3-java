/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.semantics3.api.model;

import com.google.api.client.util.Key;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jeremy
 */
public class Product extends Sem3Object {

  @Key("cat_id")
  String catID;

  @Key("offers_total")
  Integer offersTotal;

  @Key("category")
  String category;

  @Key("name")
  String name;

  @Key("description")
  String description;

  @Key("created_at")
  Long createdAt;
  @Key("updated_at")
  Long updatedAt;
  
  @Key("price")
  String price;

  @Key("brand")
  String brand;

  @Key("sem3_id")
  String sem3ID;

  @Key("geo")
  List<String> geo;

  @Key("price_currency")
  String priceCurrency;

  /*
   {
   "cat_id": "13658",
   "offers_total": 1,
   "category": "Electronics",
   "name": "Yamaha ATS-1520 Soundbar with Dual Built-In Subwoofers",
   "description": "47 1/4\" Wide - Bluetooth wireless music streaming ... (visit site URLs for full description)",
   "updated_at": 1389536912,
   "price": "248.95",
   "brand": "Yamaha",
   "created_at": 1387071892,
   "sem3_id": "5unuOoWNXsYWEWckaOoaCE",
   "sitedetails": [
   {
   "offers_count": 1,
   "sku": "ats-1520",
   "latestoffers": [
   {
   "seller": "LSC Warehouse",
   "lastrecorded_at": 1389536900,
   "currency": "USD",
   "firstrecorded_at": 1387071800,
   "availability": "Available",
   "price": "248.95",
   "id": "6PFyDfn1qigcuqqSommeY8"
   }
   ],
   "url": "http://www.lscwarehouse.com/ats-1520.html",
   "name": "lscwarehouse.com",
   "recentoffers_count": 1
   }
   ],
   "geo": [
   "usa"
   ],
   "price_currency": "USD"
   },  
   */
}
