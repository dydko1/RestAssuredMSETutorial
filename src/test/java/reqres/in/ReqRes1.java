package reqres.in;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqRes1 {

    @Test
    public void postRequestExam() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api";

        Response res =
                given()
                        .header("Content-Type", "application/json")
                        .body("{\n" +
                                "    \"name\": \"Tarun Goswami\",\n" +
                                "    \"job\": \"QA\"\n" +
                                "}")

                        .when()
                        .post("/users")
                        .then()
                        .statusCode(201)
                        .extract().response();

        System.out.println(res.body().prettyPrint());
    }
}
