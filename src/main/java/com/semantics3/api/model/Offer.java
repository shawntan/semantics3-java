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

public class Offer extends Semantics3Object { 

  /**
  * Internal Semantics3 ID of the product. You can also lookup multiple "sem3_id"s in one go as described in this update.
  */
  public static final String SEM3_ID = "sem3_id";
  /**
  * Status of the offer at the time at which it was recorded (e.g., available, out of stock, etc.).
  */
  public static final String AVAILABILITY = "availability";
  /**
  * The condition of the item that is on offer (e.g., new, refurbished, used, etc.). This field is set only if explicitly mentioned in the source of the data; if this field is empty, the product can be assumed to be of condition "new".
  */
  public static final String CONDITION = "condition";
  /**
  * Currency code associated with the specified price (and shipping price, if present). Currency codes are returned in ISO 4217 format.
  */
  public static final String CURRENCY = "currency";
  /**
  * Unique ID associated with the referenced offer.
  */
  public static final String ID = "id";
  /**
  * Price at which the product is sold at in the referenced offer. The price field is returned in standard denomination, i.e., all prices in USD are returned in dollars.
  */
  public static final String PRICE = "price";
  /**
  * Time at which this offer was first recorded in Semantics3s database.
  */
  public static final String FIRSTRECORDED_AT = "firstrecorded_at";
  /**
  * Time at which this offer was last checked.
  */
  public static final String LASTRECORDED_AT = "lastrecorded_at";
  /**
  * Name of the seller who has put up this offer for the product. This field is particularly relevant to sites that offer the products of third-party sellers.
  */
  public static final String SELLER = "seller";
  /**
  * Shipping price associated with this offer.
  */
  public static final String SHIPPING = "shipping";
  /**
  * Name of the site on which the offer was detected.
  */
  public static final String SITEDETAILS_NAME = "sitedetails_name";

  @Key(SEM3_ID)
  String sem3ID;
  @Key(AVAILABILITY)
  String availability;
  @Key(CONDITION)
  String condition;
  @Key(CURRENCY)
  String currency;
  @Key(ID)
  String id;
  @Key(PRICE)
  String price;
  @Key(FIRSTRECORDED_AT)
  Long firstRecordedAt;
  @Key(LASTRECORDED_AT)
  Long lastRecordedAt;
  @Key(SELLER)
  String seller;
  @Key(SHIPPING)
  String shipping;
  @Key(SITEDETAILS_NAME)
  String siteDetailsName;

  /**
  * Internal Semantics3 ID of the product. You can also lookup multiple "sem3_id"s in one go as described in this update.
  * @return String
  */
  public String getSem3ID() {
    return this.sem3ID;
  }
  /**
  * Status of the offer at the time at which it was recorded (e.g., available, out of stock, etc.).
  * @return String
  */
  public String getAvailability() {
    return this.availability;
  }
  /**
  * The condition of the item that is on offer (e.g., new, refurbished, used, etc.). This field is set only if explicitly mentioned in the source of the data; if this field is empty, the product can be assumed to be of condition "new".
  * @return String
  */
  public String getCondition() {
    return this.condition;
  }
  /**
  * Currency code associated with the specified price (and shipping price, if present). Currency codes are returned in ISO 4217 format.
  * @return String
  */
  public String getCurrency() {
    return this.currency;
  }
  /**
  * Unique ID associated with the referenced offer.
  * @return String
  */
  public String getID() {
    return this.id;
  }
  /**
  * Price at which the product is sold at in the referenced offer. The price field is returned in standard denomination, i.e., all prices in USD are returned in dollars.
  * @return String
  */
  public String getPrice() {
    return this.price;
  }
  /**
  * Price at which the product is sold at in the referenced offer. The price field is returned in standard denomination, i.e., all prices in USD are returned in dollars.
  * @return Date
  */
  public java.math.BigDecimal getPriceBigDecimal() {
    if(null == this.price) {
      return null;
    }

    return new java.math.BigDecimal(this.price);
  }
  /**
  * Time at which this offer was first recorded in Semantics3s database.
  * @return Long
  */
  public Long getFirstRecordedAt() {
    return this.firstRecordedAt;
  }
  /**
  * Time at which this offer was first recorded in Semantics3s database.
  * @return Date
  */
  public java.util.Date getFirstRecordedAtDate() {
    if(null == this.firstRecordedAt) {
      return null;
    }

    Long value = 1000L * this.firstRecordedAt;
    return new java.util.Date(value);
  }
  /**
  * Time at which this offer was last checked.
  * @return Long
  */
  public Long getLastRecordedAt() {
    return this.lastRecordedAt;
  }
  /**
  * Time at which this offer was last checked.
  * @return Date
  */
  public java.util.Date getLastRecordedAtDate() {
    if(null == this.lastRecordedAt) {
      return null;
    }

    Long value = 1000L * this.lastRecordedAt;
    return new java.util.Date(value);
  }
  /**
  * Name of the seller who has put up this offer for the product. This field is particularly relevant to sites that offer the products of third-party sellers.
  * @return String
  */
  public String getSeller() {
    return this.seller;
  }
  /**
  * Shipping price associated with this offer.
  * @return String
  */
  public String getShipping() {
    return this.shipping;
  }
  /**
  * Name of the site on which the offer was detected.
  * @return String
  */
  public String getSiteDetailsName() {
    return this.siteDetailsName;
  }
}