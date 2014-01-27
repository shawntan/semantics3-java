/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.semantics3.api.model;

import com.google.api.client.util.Key;
import java.util.List;

/**
 *
 * @author jeremy
 */
public class SiteDetail extends Sem3Object {
//      {
//      "offers_count": 1,

  @Key("offers_count")
  Integer offersCount;
//      "sku": "ats-1520",
  @Key("sku")
  String sku;

  @Key("latestoffers")
  List<Offer> latestoffers;

  @Key("url")
  String url;

  @Key("name")
  String name;

  @Key("recentoffers_count")
  Integer recentOffersCount;

//      "latestoffers": [
//        {
//          "seller": "LSC Warehouse",
//          "lastrecorded_at": 1389536900,
//          "currency": "USD",
//          "firstrecorded_at": 1387071800,
//          "availability": "Available",
//          "price": "248.95",
//          "id": "6PFyDfn1qigcuqqSommeY8"
//        }
//      ],
//      "url": "http://www.lscwarehouse.com/ats-1520.html",
//      "name": "lscwarehouse.com",
//      "recentoffers_count": 1
//    }
}
