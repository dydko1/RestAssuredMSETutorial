package learnitrestassuredudemy.d_06_get_cards;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class CardTest {

    @BeforeTest
    public static void setUrl() {
        RestAssured.baseURI = "https://api.trello.com/1";
    }

    private RequestSpecification requestWithAuth() {
        return RestAssured.given()
                .queryParams(Map.of(
                        "key", "6f04eeee897329faa9261fe2bca35a0b",
                        "token", "ATTA2b88bae9dfa84e8ac67cbc393c8b8468cda406428d9f3c3e43e5cd72765a2d6411212F83"
                ));
    }

    @Test
    public void getCards() {
        requestWithAuth()
                .pathParams("list_id", "657d3e2859348b240137e17c")
                .log().body()
                .get("/lists/{list_id}/cards")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getCard() {
        requestWithAuth()
                .pathParams("id", "657d42d6bdf74a8a04dce102")
                .log().body()
                .get("/cards/{id}")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", Matchers.equalTo("___!!!!!!! new cards name 1981"));
    }
}
