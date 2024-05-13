package com.coindcx.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

public class BaseTest {

    private static final String BASE_URL = "https://api.restful-api.dev";
    static ObjectMapper mapper = new ObjectMapper();

    private static void setBaseURI() {
        RestAssured.baseURI = BASE_URL;
    }

    public static Response post(String endpoint, Object payload) throws JsonProcessingException {
        // Base URL of the API
        setBaseURI();

        // Perform POST request
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(payload))
                .post(endpoint);

        // Print Request and Response
        System.out.println("Request body: " + mapper.writeValueAsString(payload));
        System.out.println("Response body: " + response.getBody().asString());
        return response;
    }

    public static Response get(String endpoint, HashMap<String, String> queryParams) {
        // Base URL of the API
        setBaseURI();

        // Perform Get request
        Response response = RestAssured.given()
                .queryParams(queryParams)
                .when()
                .get(endpoint);

        // Print URL and response body
        System.out.println("Response body: " + response.getBody().asString());
        return response;
    }

    public static Response delete(String endpoint, String key, String id) {
        // Base URL of the API
        setBaseURI();

        // Perform Delete request
        Response response = RestAssured.given()
                .pathParam(key, id)
                .when()
                .delete(endpoint);

        // Print URL and response body
        System.out.println("Response body: " + response.getBody().asString());
        return response;
    }
}
