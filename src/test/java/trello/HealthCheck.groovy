package trello

import org.testng.annotations.Test
import static io.restassured.RestAssured.given;

class HealthCheck {
    private final static String BASE_URL = "https://trello.com";

    @Test
    public void healthCheckTest() {
        given()
                .baseUri(BASE_URL)
                .when()
                .get("/")
                .prettyPrint();
    }
}
