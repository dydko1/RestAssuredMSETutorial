package reqres.in;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqResDelete {

    /*POST Request Example*/
    @Test
    public void deleteRequestExam() {

        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api";

        given()
                .when()
                .delete("/users/2")
                .then()
                .statusCode(204);

        //System.out.println(response.body().prettyPrint());
    }
}
