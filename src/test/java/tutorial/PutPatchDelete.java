package tutorial;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PutPatchDelete {

    @Test
    public void create() {
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
                .patch("/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log()
                .all();
    }

    @Test
    public void deleteTest() {
        baseURI = "https://reqres.in/api";

        given()
                .when()
                .delete("/users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .log()
                .all();

    }
}
