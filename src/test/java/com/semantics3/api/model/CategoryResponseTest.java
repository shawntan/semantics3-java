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

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jeremy
 */
public class CategoryResponseTest extends Semantics3ObjectTest<CategoryResponse> {

  @Override
  protected CategoryResponse create() {
    return new CategoryResponse();
  }

  @Test
  public void productResponseFromJson() throws IOException {
    sem3Object = fromResource("CategoryResponse.json", CategoryResponse.class);
    Assert.assertNull("total_results_count should be null", sem3Object.totalResultsCount);
    Assert.assertEquals("code should be the same", "OK", sem3Object.code);
    Assert.assertNull("offset should be null", sem3Object.offset);

    Assert.assertEquals("results_count should be the same", (Object) 12, sem3Object.resultsCount);
    Assert.assertNotNull("Results should not be null.", sem3Object.results);
    Assert.assertEquals("Results.size should be the same", (Object) 12, sem3Object.results.size());
  }
}
