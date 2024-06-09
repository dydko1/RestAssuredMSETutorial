package restfulbooker.request.get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import restfulbooker.model.BookingDates;
import restfulbooker.model.BookingFactory;

public class PostRequest {

    private final String URI = "https://restful-booker.herokuapp.com";
    private final String BASE_PATH = "/booking/{id}";
    private final String PAYLOAD = "{\n" +
            "    \"firstname\": \"Miro\",\n" +
            "    \"lastname\": \"Brown\",\n" +
            "    \"totalprice\": 343,\n" +
            "    \"depositpaid\": false,\n" +
            "    \"bookingdates\": {\n" +
            "        \"checkin\": \"2022-04-18\",\n" +
            "        \"checkout\": \"2023-10-28\"\n" +
            "    },\n" +
            "    \"additionalneeds\": \"Breakfast\"\n" +
            "}";

    @Test
    public void PostRequest() {

        RequestSpecification requestSpecification = RestAssured
                .given()
                .baseUri(URI)
                .basePath("/{basePath}");
        requestSpecification
                .when()
                .pathParams("basePath", "booking")
                .contentType(ContentType.JSON)
                .body(PAYLOAD);

        Response response = requestSpecification.post();
        response.then()
                .statusCode(HttpStatus.SC_OK);
        response
                .prettyPrint();
        //.prettyPrint();
    }

    @Test
    public void PostRequest1() {
        BookingFactory bookingFactory = new BookingFactory();
        RequestSpecification requestSpecification = RestAssured
                .given()
                .baseUri(URI)
                .basePath("/{basePath}");
        requestSpecification
                .when()
                .pathParams("basePath", "booking")
                .contentType(ContentType.JSON)
                .body(bookingFactory
                        .getBooking());

        Response response = requestSpecification.post();
        response.then()
                .statusCode(HttpStatus.SC_OK);
        response
                .prettyPrint();
        //.prettyPrint();
    }

    @Test
    public void getRequestByIdxx() {
        RequestSpecification requestSpecification = RestAssured
                .given()
                .baseUri(URI)
                .basePath("/{basePath}/{bookingid}");
        requestSpecification
                .pathParams("basePath", "booking")
                .pathParam("bookingid", 20);
        requestSpecification
                .get()
                .prettyPrint();
    }
}
