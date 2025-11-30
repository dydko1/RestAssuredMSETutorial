package com.dydko.gorest.test2;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

class GoRestCrudTest {

    private static GoRestClient goRest;  // <- KOMPOZYCJA: test "ma" klienta

    @BeforeAll
    static void setup() {
        GoRestConfig config = GoRestConfig.fromProperties("gorest.properties");
        goRest = new GoRestClient(config);
    }

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
