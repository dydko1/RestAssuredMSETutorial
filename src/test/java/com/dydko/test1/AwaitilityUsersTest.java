package com.dydko.test1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AwaitilityUsersTest {
    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    void shouldEventuallyReturn10Users() {
        // Awaitility będzie co chwilę odpalał lambdę dopóki warunek nie będzie true
        await()
                .atMost(Duration.ofSeconds(5))
                .pollInterval(Duration.ofSeconds(1))
                .until(() -> {
                    String body = given()
                            .log().uri()
                            .when()
                            .get("/users")
                            .then()
                            .log().status()
                            .extract()
                            .asString();

                    JsonPath jsonPath = new JsonPath(body);
                    List<Map<String, Object>> users = jsonPath.getList("$");

                    System.out.println("Aktualna liczba userów: " + users.size());
                    return users.size() == 10; // warunek
                });
    }

    @Test
    void shouldEventuallyHave10Users_andThenWeCanBuildMap() {
        // wersja z untilAsserted – asercje w środku
        await()
                .atMost(Duration.ofSeconds(5))
                .untilAsserted(() -> {
                    List<Map<String, Object>> users = given()
                            .when()
                            .get("/users")
                            .then()
                            .statusCode(200)
                            .extract()
                            .jsonPath()
                            .getList("$");

                    assertEquals(10, users.size());
                });
    }
}
