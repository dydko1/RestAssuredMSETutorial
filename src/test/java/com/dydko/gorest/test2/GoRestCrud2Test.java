package com.dydko.gorest.test2;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GoRestCrud2Test {

    private static GoRestClient goRest;  // <- KOMPOZYCJA: test "ma" klienta

    @BeforeAll
    static void setup() {
        GoRestConfig config = GoRestConfig.fromProperties("gorest.properties");
        goRest = new GoRestClient(config);
    }

    @Test
    void shouldCreateGetAndDeleteUser() {
        String uniqueEmail = "mirek." + System.currentTimeMillis() + "@example.com";

        User requestBody = User.builder()
                .name("Mirek Test")
                .email(uniqueEmail)
                .gender("male")
                .status("active")
                .build();

        // CREATE
        Response createResponse = given()
                .spec(goRest.auth())      // zamiast header("Authorization"...)
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .response();

        Integer userId = createResponse.jsonPath().getInt("id");
        assertNotNull(userId);

        // GET
        Response getResponse = given()
                .spec(goRest.auth())
                .when()
                .get("/users/" + userId)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();

        assertEquals("Mirek Test", getResponse.jsonPath().getString("name"));
        assertEquals(uniqueEmail, getResponse.jsonPath().getString("email"));

        // DELETE
        given()
                .spec(goRest.auth())
                .when()
                .delete("/users/" + userId)
                .then()
                .log().all()
                .statusCode(204);
    }
}
