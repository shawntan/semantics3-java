package com.semantics3.api.metrics;

/**
 * Interface is used to allow metrics collection during normal operation.
 * @author jeremy
 */
public interface MetricsCollector {
  /**
   * Records a successful call.
   * @param endPoint endPoint being called.
   */
  void recordCallSuccess(String endPoint);
  /**
   * Records that a failure occurred
   * @param endPoint endPoint being called.
   */
  void recordCallFailure(String endPoint);
  /**
   * Records the elapsed time for a call.
   * @param endPoint end point for the call
   * @param elapsed elapsed time in milliseconds
   */
  void recordEndPoint(String endPoint, long elapsed);
}
