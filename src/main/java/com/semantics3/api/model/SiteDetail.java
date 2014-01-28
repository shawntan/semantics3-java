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

public class SiteDetail extends Semantics3Object { 

  /**
  * DEPRECATED| Approximate geographical location at which the referenced site sells its products. |DEPRECATED - Please refer to the "geo" field in Section 1|
  */
  public static final String GEO = "geo";
  /**
  * List price on the site. Typically, e-commerce sites present this value as the reference price against which a marked-down price is contrasted.
  */
  public static final String LISTPRICE = "listprice";
  /**
  * Currency associated with the listprice. Currency codes are returned in ISO 4217 format.
  */
  public static final String LISTPRICE_CURRENCY = "listprice_currency";
  /**
  * Name of the website from which this data was obtained.
  */
  public static final String NAME = "name";
  /**
  * |DEPRECATED| Total number of "offers" recorded for the referenced site, each of which is available through the offers endpoint. "Offers" are explained in detail in Part B of this section; be sure to carefully read the note marked "IMPORTANT" in Part B. |DEPRECATED|
  */
  public static final String OFFERS_COUNT = "offers_count";
  /**
  * Number of "active" offers recorded when this site was last crawled. A value of "0" indicates that the product is no longer available for purchase through that link.
  */
  public static final String RECENTOFFERS_COUNT = "recentoffers_count";
  /**
  * Site SKU of the website from which this data was obtained. If one SKU has multiple variations associated with it, then this field returns the SKU provided by the website appended with an underscore and a variation specific identifier.
  */
  public static final String SKU = "sku";
  /**
  * URL pointing to the product page on the referenced site.
  */
  public static final String URL = "url";
  /**
  * Latest offers from the site
  */
  public static final String LATESTOFFERS = "latestoffers";

  @Key(GEO)
  String geo;
  @Key(LISTPRICE)
  String listPrice;
  @Key(LISTPRICE_CURRENCY)
  String listPriceCurrency;
  @Key(NAME)
  String name;
  @Key(OFFERS_COUNT)
  Integer offersCount;
  @Key(RECENTOFFERS_COUNT)
  Integer recentOffersCount;
  @Key(SKU)
  String sku;
  @Key(URL)
  String url;
  @Key(LATESTOFFERS)
  java.util.List<Offer> latestOffers;

  /**
  * DEPRECATED| Approximate geographical location at which the referenced site sells its products. |DEPRECATED - Please refer to the "geo" field in Section 1|
  * @return String
  */
  @Deprecated
  public String getGeo() {
    return this.geo;
  }
  /**
  * List price on the site. Typically, e-commerce sites present this value as the reference price against which a marked-down price is contrasted.
  * @return String
  */
  public String getListPrice() {
    return this.listPrice;
  }
  /**
  * Currency associated with the listprice. Currency codes are returned in ISO 4217 format.
  * @return String
  */
  public String getListPriceCurrency() {
    return this.listPriceCurrency;
  }
  /**
  * Name of the website from which this data was obtained.
  * @return String
  */
  public String getName() {
    return this.name;
  }
  /**
  * |DEPRECATED| Total number of "offers" recorded for the referenced site, each of which is available through the offers endpoint. "Offers" are explained in detail in Part B of this section; be sure to carefully read the note marked "IMPORTANT" in Part B. |DEPRECATED|
  * @return Integer
  */
  @Deprecated
  public Integer getOffersCount() {
    return this.offersCount;
  }
  /**
  * Number of "active" offers recorded when this site was last crawled. A value of "0" indicates that the product is no longer available for purchase through that link.
  * @return Integer
  */
  public Integer getRecentOffersCount() {
    return this.recentOffersCount;
  }
  /**
  * Site SKU of the website from which this data was obtained. If one SKU has multiple variations associated with it, then this field returns the SKU provided by the website appended with an underscore and a variation specific identifier.
  * @return String
  */
  public String getSKU() {
    return this.sku;
  }
  /**
  * URL pointing to the product page on the referenced site.
  * @return String
  */
  public String getUrl() {
    return this.url;
  }
  /**
  * Latest offers from the site
  * @return java.util.List<Offer>
  */
  public java.util.List<Offer> getLatestOffers() {
    return this.latestOffers;
  }
}