package learnitrestassuredudemy.a_02_first_api_call;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class FirstCall {
    @Test
    public void getAPITrello() {
        RestAssured.given()
                .log().all()
                .baseUri("https://api.trello.com")
                .get()
                .prettyPrint();
    }

    @Test
    public void getGoogle() {
        RestAssured.given()
                .log().all()
                .baseUri("https://google.com")
                .get()
                //.prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK);
        System.out.println("ddddddddddddd=" + HttpStatus.SC_ACCEPTED);
    }
}