package reqres.in;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.given;

public class ReqResAssert {

    String id = "2";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api";
    }

    @Test(enabled = true)
    public void pathParametersExample() {
        given()
                .queryParam("page", "2")
                .when()
                .get("/users/")
                .then()
                .statusCode(200)
                .body("total_pages", equalTo(2))
                .header("server", "cloudflare")
                .header("X-Powered-By", "Express")
                .header("Via", "1.1 vegur");
    }

    @Test
    public void postRequestExample() {
        String res =
                given()
                        .body("{" +
                                "    \"name\": \"Tarun\",\n" +
                                "    \"job\": \"Goswami\"\n" +
                                "}")

                        .when()
                        .post("/users")
                        .then()
                        .statusCode(201)
                        .extract().response().asString();

        JsonPath js = new JsonPath(res);
        System.out.println(js.get().toString());
        String id = js.getString("id");
        System.out.println("id is:" + id);
    }

    @Test(enabled = true)
    public void jsonschematest() {
        given()
                .pathParam("id", id)
                .when()
                .get("/users/{id}")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("testschema.json"));
    }

    @Test
    private void JsonBodyHashMap()
    {
        HashMap<String,Object> dataBody = new HashMap<String,Object>();

        dataBody.put("name", "Harry Potter");
        dataBody.put("email", "hoggwarts22@wiz.com");
        dataBody.put("gender", "Male");
        dataBody.put("status", "active");

        RestAssured
                .given()
                .header("Authorization","Bearer 0e1fcc0384b6c4090abb387e10ca3d4a0c94b5a3d0c62279944c020a80efbaaa")
                .baseUri("https://gorest.co.in/public/v1/users/")
                .contentType(ContentType.JSON)
                .body(dataBody)
                .log()
                .body()
                .when()
                .post()
                .then()
                .assertThat().statusCode(201)
                .log().body();
    }
}
