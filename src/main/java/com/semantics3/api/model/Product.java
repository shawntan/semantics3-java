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

public class Product extends Semantics3Object { 

  /**
  * Internal Semantics3 ID of the product. You can also lookup multiple "sem3_id"s in one go as described in this update.
  */
  public static final String SEM3_ID = "sem3_id";
  /**
  * Brand name of the product.
  */
  public static final String BRAND = "brand";
  /**
  * Category ID of the category to which the product is assigned. Query by this cat_id to retrieve similar products.
  */
  public static final String CAT_ID = "cat_id";
  /**
  * Name of the category with which the product is associated. This is purely a text search, and unlike searches on "cat_id", does not search among child nodes in the category tree. Oftentimes, this field provide more specificity than the category names available through the category tree. (Refer to the Categories section for specifics about cat_id searches).
  */
  public static final String CATEGORY = "category";
  /**
  * Color of the product.
  */
  public static final String COLOR = "color";
  /**
  * Time at which this product entry was made in Semantics3s database.
  */
  public static final String CREATED_AT = "created_at";
  /**
  * Detailed description of the product.
  */
  public static final String DESCRIPTION = "description";
  /**
  * 13-digit International Article Number (EAN) of the product. International Standard Book Numbers (ISBN) are also displayed against the ean field, since ISBN-13 is a subset of EAN. The "ean" field is included for quick and intuitive reference; we recommend that you utilize the "gtins" field, also described in this table, as far as possible.
  */
  public static final String EAN = "ean";
  /**
  * Features of the product, in hash (key-value) form. Values are always in scalar form, except when the key is "blob; all unstructured features data is stored as a value of the blob key in either array or scalar form.
  */
  public static final String FEATURES = "features";
  /**
  * Features of the product, in hash (key-value) form. Values are always in scalar form, except when the key is "blob; all unstructured features data is stored as a value of the blob key in either array or scalar form.
  */
  public static final String GTINS = "gtins";
  /**
  * Country to which you would like to limit your results. Only two values are valid for this field: "usa" (default) and "uk". At the moment, each product is linked to only one country; however, this field is returned as an array to accommodate the future possibility of a one product to many countries relationships
  */
  public static final String GEO = "geo";
  /**
  * Height of the product (in millimeters).
  */
  public static final String HEIGHT = "height";
  /**
  * Array of URLs pointing to images of the product. These images are hosted on Semantics3s servers.
  */
  public static final String IMAGES = "images";
  /**
  * Number of image URLs contained in the images array. Use this field if you wish to restrict your responses to products that have your desired number of associated image URLs.
  */
  public static final String IMAGES_TOTAL = "images_total";
  /**
  * Length of the product (in millimeters).
  */
  public static final String LENGTH = "length";
  /**
  * Manufacturer of the product.
  */
  public static final String MANUFACTURER = "manufacturer";
  /**
  * Model of the product.
  */
  public static final String MODEL = "model";
  /**
  * Manufacturer part number of the product.
  */
  public static final String MPN = "mpn";
  /**
  * Name of the product.
  */
  public static final String NAME = "name";
  /**
  * Total number of offers recorded for the given product, across all websites. An "offer" is a snapshot of the price of the product at a particular time. Offers vary on fields such as seller, price, availability and condition. This API (Products API) returns only a limited number offers in each response; the offers_total field doesnt reflect this number, rather, it represents the total number of offers that have been gathered over time for the given product, all of which can be accessed through the offers endpoint. Additional details are provided in the Section 2.
  */
  public static final String OFFERS_TOTAL = "offers_total";
  /**
  * We capture several prices for each product, made available in the sitedetails section and through the offers endpoint. However, you may face the need to attribute a single quick-and-dirty representative price point to each product. This "price" is selected from among all the offers and list prices associated with the product across several sites using several rules refined over time. It can be used for sorting by price, easily filtering by price and more. The currency associated with this field is reflected in the "price_currency".
  */
  public static final String PRICE = "price";
  /**
  * Reflects the ISO 4217 currency value associated with the "price" field. This field has been added to resolve confusion over the "price" field. It is not query-able. Look to the "geo" field to restrict your searches to specific geographies.
  */
  public static final String PRICE_CURRENCY = "price_currency";
  /**
  * Size of the product.
  */
  public static final String SIZE = "size";
  /**
  * 12-digit Universal Product Code (UPC) code of the product. The "upc" field is included for quick and intuitive reference; we recommend that you utilize the "gtins" field, also described in this table, as far as possible.
  */
  public static final String UPC = "upc";
  /**
  * Time at which the data in this product response was last refreshed from its parent sources.
  */
  public static final String UPDATED_AT = "updated_at";
  /**
  * Often, the same product may be available in multiple colors, formats and sizes (this is particularly true of clothing and footwear). If a product returned by the API contains a variation_id field, you can query by this field to retrieve all associated variations. Note, by default, unless variation_id is specified, responses to the products API contain only one variation of each product.
  */
  public static final String VARIATION_ID = "variation_id";
  /**
  * Weight of the product (In milligrams).
  */
  public static final String WEIGHT = "weight";
  /**
  * Width of the product (in millimeters).
  */
  public static final String WIDTH = "width";
  /**
  * Actor(s) of the movie/TV show. Multiple values are separated by commas. Movies & TV [15532]
  */
  public static final String ACTOR = "actor";
  /**
  * Arist(s) associated with the referenced music item. Movies & TV [15532] Music [18735]
  */
  public static final String ARTIST = "artist";
  /**
  * Author of the book. Books [12597]
  */
  public static final String AUTHOR = "author";
  /**
  * Department under which the product falls.	Baby Products [21995], Beauty [13157], Clothing & Accessories [17366]
  */
  public static final String DEPARTMENT = "department";
  /**
  * Director(s) of the movie/TV show. Multiple values are separated by commas.	Movies & TV [15532]
  */
  public static final String DIRECTOR = "director";
  /**
  * Format in which the product is delivered.	Books [12597], Movies & TV [15532], Music [18735], Video Games [11932]
  */
  public static final String FORMAT = "format";
  /**
  * Genre associated with the product.	Video Games [11932]
  */
  public static final String GENRE = "genre";
  /**
  * Record (label) associated with the item of music.	Music [18735]
  */
  public static final String LABEL = "label";
  /**
  * Language in which the contents of the product are delivered.	Books [12597], Movies & TV [15532], Music [18735]
  */
  public static final String LANGUAGE = "language";
  /**
  * Operating system of the product.	Mobile Phones [915], Software [10539]
  */
  public static final String OPERATINGSYSTEM = "operatingsystem";
  /**
  * Platform (typically software) on which the product runs.	Software [10539], Video Games [11932]
  */
  public static final String PLATFORM = "platform";
  /**
  * Producer(s) of the movie/TV show. Multiple values are separated by commas.	Movies & TV [15532]
  */
  public static final String PRODUCER = "producer";
  /**
  * Publisher of the book.	Books [12597]
  */
  public static final String PUBLISHER = "publisher";
  /**
  * Running time, in minutes, of the movie/TV show.	Movies & TV [15532]
  */
  public static final String RUNNINGTIME = "runningtime";
  /**
  * Studio associated with the movie/TV show.	Movies & TV [15532]
  */
  public static final String STUDIO = "studio";
  /**
  * Writer(s) of the movie/TV show. Multiple values are separated by commas.	Movies & TV [15532]
  */
  public static final String WRITER = "writer";

  @Key(SEM3_ID)
  String sem3ID;
  @Key(BRAND)
  String brand;
  @Key(CAT_ID)
  String catID;
  @Key(CATEGORY)
  String category;
  @Key(COLOR)
  String color;
  @Key(CREATED_AT)
  Long createdAt;
  @Key(DESCRIPTION)
  String description;
  @Key(EAN)
  String ean;
  @Key(FEATURES)
  java.util.Map<String, String> features;
  @Key(GTINS)
  java.util.List<String> gtins;
  @Key(GEO)
  java.util.List<String> geo;
  @Key(HEIGHT)
  String height;
  @Key(IMAGES)
  java.util.List<String> images;
  @Key(IMAGES_TOTAL)
  Integer imagesTotal;
  @Key(LENGTH)
  String length;
  @Key(MANUFACTURER)
  String manufacturer;
  @Key(MODEL)
  String model;
  @Key(MPN)
  String mpn;
  @Key(NAME)
  String name;
  @Key(OFFERS_TOTAL)
  Integer offersTotal;
  @Key(PRICE)
  String price;
  @Key(PRICE_CURRENCY)
  String priceCurrency;
  @Key(SIZE)
  String size;
  @Key(UPC)
  String upc;
  @Key(UPDATED_AT)
  Long updatedAt;
  @Key(VARIATION_ID)
  String variationID;
  @Key(WEIGHT)
  String weight;
  @Key(WIDTH)
  String width;
  @Key(ACTOR)
  String actor;
  @Key(ARTIST)
  String artist;
  @Key(AUTHOR)
  String author;
  @Key(DEPARTMENT)
  String department;
  @Key(DIRECTOR)
  String director;
  @Key(FORMAT)
  String format;
  @Key(GENRE)
  String genre;
  @Key(LABEL)
  String label;
  @Key(LANGUAGE)
  String language;
  @Key(OPERATINGSYSTEM)
  String operatingSystem;
  @Key(PLATFORM)
  String platform;
  @Key(PRODUCER)
  String producer;
  @Key(PUBLISHER)
  String publisher;
  @Key(RUNNINGTIME)
  String runningTime;
  @Key(STUDIO)
  String studio;
  @Key(WRITER)
  String writer;

  /**
  * Internal Semantics3 ID of the product. You can also lookup multiple "sem3_id"s in one go as described in this update.
  * @return String
  */
  public String getSem3ID() {
    return this.sem3ID;
  }
  /**
  * Brand name of the product.
  * @return String
  */
  public String getBrand() {
    return this.brand;
  }
  /**
  * Category ID of the category to which the product is assigned. Query by this cat_id to retrieve similar products.
  * @return String
  */
  public String getCatID() {
    return this.catID;
  }
  /**
  * Name of the category with which the product is associated. This is purely a text search, and unlike searches on "cat_id", does not search among child nodes in the category tree. Oftentimes, this field provide more specificity than the category names available through the category tree. (Refer to the Categories section for specifics about cat_id searches).
  * @return String
  */
  public String getCategory() {
    return this.category;
  }
  /**
  * Color of the product.
  * @return String
  */
  public String getColor() {
    return this.color;
  }
  /**
  * Time at which this product entry was made in Semantics3s database.
  * @return Long
  */
  public Long getCreatedAt() {
    return this.createdAt;
  }
  /**
  * Time at which this product entry was made in Semantics3s database.
  * @return Date
  */
  public java.util.Date getCreatedAtDate() {
    if(null == this.createdAt) {
      return null;
    }

    Long value = 1000L * this.createdAt;
    return new java.util.Date(value);
  }
  /**
  * Detailed description of the product.
  * @return String
  */
  public String getDescription() {
    return this.description;
  }
  /**
  * 13-digit International Article Number (EAN) of the product. International Standard Book Numbers (ISBN) are also displayed against the ean field, since ISBN-13 is a subset of EAN. The "ean" field is included for quick and intuitive reference; we recommend that you utilize the "gtins" field, also described in this table, as far as possible.
  * @return String
  */
  public String getEAN() {
    return this.ean;
  }
  /**
  * Features of the product, in hash (key-value) form. Values are always in scalar form, except when the key is "blob; all unstructured features data is stored as a value of the blob key in either array or scalar form.
  * @return java.util.Map<String, String>
  */
  public java.util.Map<String, String> getFeatures() {
    return this.features;
  }
  /**
  * Features of the product, in hash (key-value) form. Values are always in scalar form, except when the key is "blob; all unstructured features data is stored as a value of the blob key in either array or scalar form.
  * @return java.util.List<String>
  */
  public java.util.List<String> getGTINS() {
    return this.gtins;
  }
  /**
  * Country to which you would like to limit your results. Only two values are valid for this field: "usa" (default) and "uk". At the moment, each product is linked to only one country; however, this field is returned as an array to accommodate the future possibility of a one product to many countries relationships
  * @return java.util.List<String>
  */
  public java.util.List<String> getGeo() {
    return this.geo;
  }
  /**
  * Height of the product (in millimeters).
  * @return String
  */
  public String getHeight() {
    return this.height;
  }
  /**
  * Height of the product (in millimeters).
  * @return Date
  */
  public Double getHeightDouble() {
    if(null == this.height) {
      return null;
    }

    return Double.parseDouble(this.height);
  }
  /**
  * Array of URLs pointing to images of the product. These images are hosted on Semantics3s servers.
  * @return java.util.List<String>
  */
  public java.util.List<String> getImages() {
    return this.images;
  }
  /**
  * Number of image URLs contained in the images array. Use this field if you wish to restrict your responses to products that have your desired number of associated image URLs.
  * @return Integer
  */
  public Integer getImagesTotal() {
    return this.imagesTotal;
  }
  /**
  * Length of the product (in millimeters).
  * @return String
  */
  public String getLength() {
    return this.length;
  }
  /**
  * Length of the product (in millimeters).
  * @return Date
  */
  public Double getLengthDouble() {
    if(null == this.length) {
      return null;
    }

    return Double.parseDouble(this.length);
  }
  /**
  * Manufacturer of the product.
  * @return String
  */
  public String getManufacturer() {
    return this.manufacturer;
  }
  /**
  * Model of the product.
  * @return String
  */
  public String getModel() {
    return this.model;
  }
  /**
  * Manufacturer part number of the product.
  * @return String
  */
  public String getMPN() {
    return this.mpn;
  }
  /**
  * Name of the product.
  * @return String
  */
  public String getName() {
    return this.name;
  }
  /**
  * Total number of offers recorded for the given product, across all websites. An "offer" is a snapshot of the price of the product at a particular time. Offers vary on fields such as seller, price, availability and condition. This API (Products API) returns only a limited number offers in each response; the offers_total field doesnt reflect this number, rather, it represents the total number of offers that have been gathered over time for the given product, all of which can be accessed through the offers endpoint. Additional details are provided in the Section 2.
  * @return Integer
  */
  public Integer getOffersTotal() {
    return this.offersTotal;
  }
  /**
  * We capture several prices for each product, made available in the sitedetails section and through the offers endpoint. However, you may face the need to attribute a single quick-and-dirty representative price point to each product. This "price" is selected from among all the offers and list prices associated with the product across several sites using several rules refined over time. It can be used for sorting by price, easily filtering by price and more. The currency associated with this field is reflected in the "price_currency".
  * @return String
  */
  public String getPrice() {
    return this.price;
  }
  /**
  * We capture several prices for each product, made available in the sitedetails section and through the offers endpoint. However, you may face the need to attribute a single quick-and-dirty representative price point to each product. This "price" is selected from among all the offers and list prices associated with the product across several sites using several rules refined over time. It can be used for sorting by price, easily filtering by price and more. The currency associated with this field is reflected in the "price_currency".
  * @return Date
  */
  public java.math.BigDecimal getPriceBigDecimal() {
    if(null == this.price) {
      return null;
    }

    return new java.math.BigDecimal(this.price);
  }
  /**
  * Reflects the ISO 4217 currency value associated with the "price" field. This field has been added to resolve confusion over the "price" field. It is not query-able. Look to the "geo" field to restrict your searches to specific geographies.
  * @return String
  */
  public String getPriceCurrency() {
    return this.priceCurrency;
  }
  /**
  * Size of the product.
  * @return String
  */
  public String getSize() {
    return this.size;
  }
  /**
  * 12-digit Universal Product Code (UPC) code of the product. The "upc" field is included for quick and intuitive reference; we recommend that you utilize the "gtins" field, also described in this table, as far as possible.
  * @return String
  */
  public String getUPC() {
    return this.upc;
  }
  /**
  * Time at which the data in this product response was last refreshed from its parent sources.
  * @return Long
  */
  public Long getUpdatedAt() {
    return this.updatedAt;
  }
  /**
  * Often, the same product may be available in multiple colors, formats and sizes (this is particularly true of clothing and footwear). If a product returned by the API contains a variation_id field, you can query by this field to retrieve all associated variations. Note, by default, unless variation_id is specified, responses to the products API contain only one variation of each product.
  * @return String
  */
  public String getVariationID() {
    return this.variationID;
  }
  /**
  * Weight of the product (In milligrams).
  * @return String
  */
  public String getWeight() {
    return this.weight;
  }
  /**
  * Weight of the product (In milligrams).
  * @return Date
  */
  public Double getWeightDouble() {
    if(null == this.weight) {
      return null;
    }

    return Double.parseDouble(this.weight);
  }
  /**
  * Width of the product (in millimeters).
  * @return String
  */
  public String getWidth() {
    return this.width;
  }
  /**
  * Width of the product (in millimeters).
  * @return Date
  */
  public Double getWidthDouble() {
    if(null == this.width) {
      return null;
    }

    return Double.parseDouble(this.width);
  }
  /**
  * Actor(s) of the movie/TV show. Multiple values are separated by commas. Movies & TV [15532]
  * @return String
  */
  public String getActor() {
    return this.actor;
  }
  /**
  * Arist(s) associated with the referenced music item. Movies & TV [15532] Music [18735]
  * @return String
  */
  public String getArtist() {
    return this.artist;
  }
  /**
  * Author of the book. Books [12597]
  * @return String
  */
  public String getAuthor() {
    return this.author;
  }
  /**
  * Department under which the product falls.	Baby Products [21995], Beauty [13157], Clothing & Accessories [17366]
  * @return String
  */
  public String getDepartment() {
    return this.department;
  }
  /**
  * Director(s) of the movie/TV show. Multiple values are separated by commas.	Movies & TV [15532]
  * @return String
  */
  public String getDirector() {
    return this.director;
  }
  /**
  * Format in which the product is delivered.	Books [12597], Movies & TV [15532], Music [18735], Video Games [11932]
  * @return String
  */
  public String getFormat() {
    return this.format;
  }
  /**
  * Genre associated with the product.	Video Games [11932]
  * @return String
  */
  public String getGenre() {
    return this.genre;
  }
  /**
  * Record (label) associated with the item of music.	Music [18735]
  * @return String
  */
  public String getLabel() {
    return this.label;
  }
  /**
  * Language in which the contents of the product are delivered.	Books [12597], Movies & TV [15532], Music [18735]
  * @return String
  */
  public String getLanguage() {
    return this.language;
  }
  /**
  * Operating system of the product.	Mobile Phones [915], Software [10539]
  * @return String
  */
  public String getOperatingSystem() {
    return this.operatingSystem;
  }
  /**
  * Platform (typically software) on which the product runs.	Software [10539], Video Games [11932]
  * @return String
  */
  public String getPlatform() {
    return this.platform;
  }
  /**
  * Producer(s) of the movie/TV show. Multiple values are separated by commas.	Movies & TV [15532]
  * @return String
  */
  public String getProducer() {
    return this.producer;
  }
  /**
  * Publisher of the book.	Books [12597]
  * @return String
  */
  public String getPublisher() {
    return this.publisher;
  }
  /**
  * Running time, in minutes, of the movie/TV show.	Movies & TV [15532]
  * @return String
  */
  public String getRunningTime() {
    return this.runningTime;
  }
  /**
  * Studio associated with the movie/TV show.	Movies & TV [15532]
  * @return String
  */
  public String getStudio() {
    return this.studio;
  }
  /**
  * Writer(s) of the movie/TV show. Multiple values are separated by commas.	Movies & TV [15532]
  * @return String
  */
  public String getWriter() {
    return this.writer;
  }
}