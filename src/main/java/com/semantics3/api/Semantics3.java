package com.semantics3.api;

import com.semantics3.api.model.Semantics3Object;
import java.io.IOException;

/**
 *
 * @author jeremy
 */
public interface Semantics3 {
  <T extends Semantics3Object> T query(Semantics3Url url, Class<T> type) throws IOException;
}

