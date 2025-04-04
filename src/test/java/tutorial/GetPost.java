package tutorial;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GetPost {

    @Test
    public void testGet() {
        baseURI = "https://reqres.in/api";
        given()
                .get("users?page=1")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("data[5].first_name", equalTo("Tracey"))
                .body("data.first_name", hasItems("Tracey", "George", "Eve"));
    }

    @Test
    public void testPost() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Mirek");
        map.put("job", "QA Engineer poganiacz owiec");

        JSONObject request = new JSONObject(map);
        //System.out.println(request.toJSONString());
        baseURI = "https://reqres.in/api";
        given()
                //.header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log()
                .all();
    }
}
