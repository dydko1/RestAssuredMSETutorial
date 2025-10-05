package base;

import io.restassured.RestAssured;

import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class TrelloTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://api.trello.com/1";
    }

    protected RequestSpecification requestWithAuth() {
        return RestAssured.given()
                .queryParams(Map.of("key", "6f04eeee897329faa9261fe2bca35a0b",
                        "token", "ATTA2b88bae9dfa84e8ac67cbc393c8b8468cda406428d9f3c3e43e5cd72765a2d6411212F83"));
    }

    @Test
    public void test() {
        requestWithAuth()
                .get("/members/me/boards")
                .then()
                .statusCode(200)
                .body("name", Matchers.contains("_This board is test board OK", "Aktualna tablica", "task_4_Miro1111"));
    }

    @Test
    public void test2() {
        requestWithAuth()
                .queryParam("fields", "id,name")
                .get("/members/me/boards")
                //.then()
                .prettyPrint();
                //.statusCode(200);

    }

    @Test
    public void checkGetBoard() {
        requestWithAuth()
                .pathParam("id", "67f7645f2d9626d21ecfa3bf")
                .get("/boards/{id}")
                .then()
                .statusCode(200)
                .body("name", Matchers.equalTo("task_4_Miro1111"));

    }
}
