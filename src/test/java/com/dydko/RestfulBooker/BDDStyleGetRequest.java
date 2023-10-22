package com.dydko.RestfulBooker;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class BDDStyleGetRequest {

    @Test
    public void GetBookingIds_VerifyStatusCode() {

        // Given
        given()
                .baseUri("https://restful-booker.herokuapp.com")
                .when()
                .get("/booking")
                .then()
                .statusLine("HTTP/1.1 200 OK");
    }
}