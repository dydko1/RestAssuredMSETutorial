package udemyapitestingrestassured;

import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.SC_CREATED;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class TC_009_POST_BDD1 {

    private static final String STUDENT_END_POINT = "https://thetestingworldapi.com/api/studentsdetails";
    String studentData = "{\n" +
            "    \"first_name\": \"Miro555\",\n" +
            "    \"middle_name\": \"Leszek1111xxxxxxyyyyyxxxxxxx\",\n" +
            "    \"last_name\": \"dydko\",\n" +
            "    \"date_of_birth\": \"sample string 5\"\n" +
            "}";

    @Test
    public void postBddFormat() {
        Response res = given()
                .contentType(ContentType.JSON)
                .body(studentData)
                .when()
                .post(STUDENT_END_POINT);

        res
                .then()
                .statusCode(SC_CREATED);
        res
                .body()
                .prettyPrint();
        System.out.println("-----------------------");
        res
                .prettyPrint();
        System.out.println("-----------------------");
        System.out.println(res.jsonPath().getString("id"));
    }
}
