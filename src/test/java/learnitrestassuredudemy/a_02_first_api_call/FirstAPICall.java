package learnitrestassuredudemy.a_02_first_api_call;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class FirstAPICall {
    @Test
    public void getGoogle() {
        RestAssured.given()
                .log().all()
                .baseUri("https://api.trello.com")
                .get();
    }
}
