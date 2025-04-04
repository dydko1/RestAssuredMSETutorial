package localapi;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LocalApiTest {

    @BeforeTest
    public void setup() {
        baseURI = "http://127.0.0.1:3000";
    }

    @Test
    public void get1Test() {

        given()
                .get("/users")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .all();
    }

    @Test
    public void post1Test() {

        JSONObject user = new JSONObject();
        user.put("id", "6");
        user.put("subjectId", "11");
        user.put("firstName", "Miro1223");
        user.put("lastName", "Dydko1111");

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user)
                .when()
                .post("/users")
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    public void put1Test() {

        JSONObject user = new JSONObject();
        //user.put("id", "6");
        user.put("subjectId", "1123saddddddddddddddddddddddd123123");
        user.put("firstName", "Mir13123");
        user.put("lastName", "Dyd21321");

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user)
                .when()
                .put("/users/6")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test

    public void delete1Test() {
        given().
        when()
                .delete("/users/5")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
