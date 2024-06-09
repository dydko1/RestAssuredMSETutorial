package restfulbooker.request.get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class PatchRequest {
    private final String BASE_URL = "https://restful-booker.herokuapp.com";
    private final String BASE_PATCH = "/{basePatch}/{id}";
    private final String BODY = "{ \"firstname\":\"Miro4234\",\"lastname\":\"Mirrrrrrrrrrrrrrrrrrrrrrr\"}";

    @Test
    public void patchRequest() {
        RequestSpecification requestSpecification = RestAssured
                .given()
                .baseUri(BASE_URL)
                .basePath(BASE_PATCH)
                .pathParams("basePatch", "booking", "id", 20);
        Response response = requestSpecification
                .when()
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .contentType(ContentType.JSON)
                .body(BODY)
                .patch();
        response
                .then()
                .statusCode(HttpStatus.SC_OK);
        response
                .prettyPrint();
        String s = response
                .jsonPath()
                .get("lastname");
        System.out.println(s);
    }
}