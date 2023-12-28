package learnitrestassuredudemy.d_06_get_cards;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class BoardJsonValidSchemaTest {

    @BeforeTest
    public static void setBaseUrl() {
        RestAssured.baseURI = "https://api.trello.com/1";
    }

    @Test
    public void getBoards() {
        RestAssured.given()
                .queryParams(Map.of(
                        "key", "6f04eeee897329faa9261fe2bca35a0b",
                        "token", "ATTA2b88bae9dfa84e8ac67cbc393c8b8468cda406428d9f3c3e43e5cd72765a2d6411212F83"
                ))
                .pathParams("member", "miroslawdyduch")
                .get("/members/{member}/boards")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK)
        ;
    }

    @Test
    public void getBoard() {
        RestAssured.given()
                .queryParams(
                        "key", "6f04eeee897329faa9261fe2bca35a0b",
                        "token", "ATTA2b88bae9dfa84e8ac67cbc393c8b8468cda406428d9f3c3e43e5cd72765a2d6411212F83",
                        "fields", "id,name"
                )
                .pathParams("id", "657d413256de270c186b014d")
                //.log().all()
                .get("/boards/{id}/")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK)
                //.body("name", Matchers.equalTo("Aktualna tablica"));
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/get_board.json"));
    }
}
