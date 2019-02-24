package com.semantics3.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

public class ConnectionBuilder {
    private static final String USER_AGENT_KEY = "User-Agent";
    private static final String USER_AGENT_VALUE = "Semantics3 Java Library";

    public HttpURLConnection buildConnection(String req, ConnectionProperties connectionProperties)
            throws IOException, URISyntaxException {
        URL url = new URL(req);
        url = url.toURI().normalize().toURL();

        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestProperty(USER_AGENT_KEY, USER_AGENT_VALUE);

        request.setConnectTimeout(connectionProperties.getConnectionTimeout());
        request.setReadTimeout(connectionProperties.getReadTimeout());

        return request;
    }
}
