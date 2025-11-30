package com.dydko.gorest.test1;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

class GoRestCrudTest extends GoRestBaseTest {

    @Test
    void shouldCreateGetAndDeleteUser() {
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

        given()
                .header("Authorization", "Bearer " + TOKEN)
                .when()
                .delete("/users/" + userId)
                .then()
                .log().all()
                .statusCode(204);
    }
}