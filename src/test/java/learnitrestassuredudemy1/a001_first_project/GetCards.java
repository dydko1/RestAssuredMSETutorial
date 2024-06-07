package learnitrestassuredudemy1.a001_first_project;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GetCards {

    @BeforeTest
    public static void setBaseUrl() {
        RestAssured.baseURI = "https://api.trello.com/1";
    }

    private RequestSpecification requestWithAuth() {
        return RestAssured.given()
                .queryParams(
                        "key", "6f04eeee897329faa9261fe2bca35a0b",
                        "token", "ATTA2b88bae9dfa84e8ac67cbc393c8b8468cda406428d9f3c3e43e5cd72765a2d6411212F83"
                );

        //.then()
        //extract().jsonPath().getString("name");
        //.statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void checkGetCars() {
        requestWithAuth()
                .queryParams("fields", "id,name")
                .pathParams("list_id", "65632e2f9ac66db0ca790fdb")
                //.log().all()
                .get("/lists/{list_id}/cards")
                .prettyPrint();
    }
}
