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
import java.util.List;

public abstract class Response<T extends Semantics3Object> extends Semantics3Object {

  @Key("total_results_count")
  Integer totalResultsCount;

  @Key("offset")
  Integer offset;

  @Key("results_count")
  Integer resultsCount;

  @Key("code")
  String code;

  @Key("results")
  List<T> results;

  public Integer getOffset() {
    return offset;
  }

  public List<T> getResults() {
    return results;
  }

  public Integer getResultsCount() {
    return resultsCount;
  }

  public Integer getTotalResultsCount() {
    return totalResultsCount;
  }

  /*
   "total_results_count": 100000,
   "code": "OK",
   "offset": 0,
   "results_count": 10,
   "results": [
  
   */
  public String getCode() {
    return code;
  }
}
