package com.semantics3.api.metrics;

/**
 * Metrics collector that does nothing.
 * @author jeremy
 */
public class NullMetricsCollector implements MetricsCollector {

  public void recordEndPoint(String endPoint, long elapsed) {

  }

  public void recordCallSuccess(String endPoint) {
    
  }

  public void recordCallFailure(String endPoint) {
    
  }
  
}
