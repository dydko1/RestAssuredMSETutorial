package tutorial;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestTest {

    @Test
    public void test1() {
        Response response = get("https://reqres.in/api/users/2");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("Content-Type"));

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
    }

    @Test
    public void test2() {
        baseURI = "https://reqres.in/api";

        given()
                .get("/users?page=1")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("data[3].id", equalTo(4));
    }
}
