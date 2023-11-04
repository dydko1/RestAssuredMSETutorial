package reqres.in;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqResPost {

    /*POST Request Example*/
    @Test
    public void postRequestExam() {

        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api";

        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"Mirosław Dyduch1\",\n" +
                        "    \"job\": \"QA\"\n" +
                        "}")
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract().response();

        System.out.println(response.body().prettyPrint());
    }
}
