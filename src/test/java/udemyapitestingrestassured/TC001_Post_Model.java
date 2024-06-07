package udemyapitestingrestassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;

public class TC001_Post_Model {
    private static final String STUDENT_END_POINT = "https://thetestingworldapi.com/api/studentsdetails";
    private PostModelData postModelData = new PostModelData("Mirek", "Leszek1981", "Dydko", "20051981");

    @Test
    public void postModelData() {
        Response res = given()
                .contentType(ContentType.JSON)
                .body(postModelData)
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
