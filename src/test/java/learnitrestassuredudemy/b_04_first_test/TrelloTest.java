package learnitrestassuredudemy.b_04_first_test;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TrelloTest {

    @BeforeTest
    public static void setBaseUrl() {
        RestAssured.baseURI = "https://api.trello.com";
    }

    @Test
    public void checkTrelloApi() {
        RestAssured.given()
                .log().all()
                .get()
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
