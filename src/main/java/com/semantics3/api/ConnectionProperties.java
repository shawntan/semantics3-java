package com.semantics3.api;

public class ConnectionProperties {
    private static final int DEFAULT_NO_TIMEOUT = 0;

    private int readTimeout = DEFAULT_NO_TIMEOUT;
    private int connectionTimeout = DEFAULT_NO_TIMEOUT;


    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }
}
