package restfulbooker.request.get;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetRequest {

    private final String URI = "https://restful-booker.herokuapp.com";
    private final String BASE_PATH = "/booking/{id}";

    @Test
    public void getRequest() {
        RequestSpecification requestSpecification = RestAssured
                .given()
                .baseUri(URI)
                .basePath(BASE_PATH);
        requestSpecification
                .pathParam("id", 10);
        requestSpecification
                .get()
                .prettyPrint();
    }

    @Test
    public void getRequest1() {
        RequestSpecification requestSpecification = RestAssured
                .given()
                .baseUri(URI)
                .basePath("/{basePath}/{bookingid}");
        requestSpecification
                .pathParams("basePath", "booking")
                .pathParam("bookingid", 10);
        requestSpecification
                .get()
                .prettyPrint();
    }
}
