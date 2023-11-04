package reqres.in;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqResGet {
    private final String id = "2";

    @Test
    public void statusCodeVerification() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users";

        Response res =
                given()
                        .pathParam("id", id)
                        .when()
                        .get("{id}");

        System.out.println(res.body().prettyPrint());
    }
}