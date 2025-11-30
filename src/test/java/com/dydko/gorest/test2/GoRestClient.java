package com.dydko.gorest.test2;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class GoRestClient {

    private final GoRestConfig config;
    private final RequestSpecification authSpec;

    public GoRestClient(GoRestConfig config) {
        this.config = config;

        // ustawiamy baseURI globalnie (można, ale nie trzeba)
        RestAssured.baseURI = config.baseUri();

        this.authSpec = new RequestSpecBuilder()
                .setBaseUri(config.baseUri())
                .addHeader("Authorization", "Bearer " + config.token())
                .setContentType(ContentType.JSON)
                .build();
    }

    public RequestSpecification auth() {
        return authSpec;
    }

    public String baseUri() {
        return config.baseUri();
    }
}