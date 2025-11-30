package com.dydko.test1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

class ApiSmokeTest {

    @Test
    void shouldReturn200ForUsersEndpoint() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        RestAssured
                .given()
                .log().uri()          // pokaże w logu jaki URL
                .when()
                .get("/users")
                .then()
                .log().status()       // pokaże status
                .statusCode(200);     // podstawowa asercja
    }
}