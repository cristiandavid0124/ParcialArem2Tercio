package com.edu.eci.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class RoundRobinService {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final Logger LOGGER = LoggerFactory.getLogger(RoundRobinService.class);

   
    private static final String LINEAR_SEARCH_SERVICE_URL = "http://localhost:8081";
    private static final String BINARY_SEARCH_SERVICE_URL = "http://localhost:8082";

    public JsonObject getConnection(String list, String value, String operation) throws Exception {
      
        String serviceUrl = getServiceUrl(operation);
        URL url = buildUrl(serviceUrl, list, value, operation);
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = connection.getResponseCode();
        LOGGER.info("GET Response Code :: {}", responseCode);

        StringBuilder response = new StringBuilder();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            LOGGER.info("Response: {}", response.toString());
        } else {
            LOGGER.error("GET request failed");
            throw new IOException("Failed to get response from server");
        }

        return JsonParser.parseString(response.toString()).getAsJsonObject();
    }

    private String getServiceUrl(String operation) {
        if ("/linearsearch".equals(operation)) {
            return LINEAR_SEARCH_SERVICE_URL;
        } else if ("/binarysearch".equals(operation)) {
            return BINARY_SEARCH_SERVICE_URL;
        } else {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    private URL buildUrl(String serviceUrl, String list, String value, String operation) throws Exception {
        return UriComponentsBuilder.fromHttpUrl(serviceUrl + operation)
                .queryParam("list", list)
                .queryParam("value", value)
                .build()
                .toUri()
                .toURL();
    }
}
