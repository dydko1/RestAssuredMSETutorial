package com.dydko.gorest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GoRestCrudTest {

    private static final String TOKEN = "0e1fcc0384b6c4090abb387e10ca3d4a0c94b5a3d0c62279944c020a80efbaaa";

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
    }

    @Test
    void shouldCreateGetAndDeleteUser() {
        // 1) CREATE (POST /users)
        String uniqueEmail = "mirek." + System.currentTimeMillis() + "@example.com";

        String requestBody = """
                {
                  "name": "Mirek Test",
                  "email": "%s",
                  "gender": "male",
                  "status": "active"
                }
                """.formatted(uniqueEmail);

        Response createResponse = given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType("application/json")
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

        System.out.println("Created user id = " + userId);

        // 2) GET /users/{id}
        Response getResponse = given()
                .header("Authorization", "Bearer " + TOKEN)
                .when()
                .get("/users/" + userId)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();

        assertEquals("Mirek Test", getResponse.jsonPath().getString("name"));
        assertEquals(uniqueEmail, getResponse.jsonPath().getString("email"));

        // 3) DELETE /users/{id}
        given()
                .header("Authorization", "Bearer " + TOKEN)
                .when()
                .delete("/users/" + userId)
                .then()
                .log().all()
                .statusCode(204);
    }
}