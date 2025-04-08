package programautomatycy.StartTest;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import programautomatycy.StartTest.serialising.AddItemToCardRequestPojo;
import programautomatycy.utils.GetPropertyValues;

import java.util.Map;

public class ServiceHelper {

    static GetPropertyValues getPropertyValues = new GetPropertyValues();
    private static final String LOGIN = getPropertyValues.getProperty("login");
    private static final String PASSWORD = getPropertyValues.getProperty("password");
    private static final String SHOP_SERVER_URL = getPropertyValues.getProperty("shopServerUrl");
    private static final SampleRest SAMPLE_REST = new SampleRest();

    public void addItem(Integer product_id, Integer quantity, Boolean returnCart, String endPoint) {
        SAMPLE_REST.response =
                given().
                        auth().
                        preemptive().
                        basic(LOGIN, PASSWORD).
                        contentType("application/json").
                        queryParam("product_id", product_id).
                        queryParam("quantity1", quantity).
                        queryParam("returnCart", returnCart).
                        baseUri(SHOP_SERVER_URL).
                        post(endPoint);
    }

    public void sendPostRequest(Map<String, Object> queryParamsBody, String endPoint) {
        SAMPLE_REST.response = given().
                auth().
                preemptive().
                basic(LOGIN, PASSWORD).
                contentType("application/json").
                queryParams(queryParamsBody).
                baseUri(SHOP_SERVER_URL).
                post(endPoint);
    }

    public Response sendPostRequest(String body, String endPoint) {
        SAMPLE_REST.response = given().
                auth().
                preemptive().
                basic(LOGIN, PASSWORD).
                contentType("application/json").
                body(body).
                baseUri(SHOP_SERVER_URL).
                post(endPoint);
        return  SAMPLE_REST.response;
    }

    public Response sendGetRequest(String endpoint) {

        SAMPLE_REST.response = given().
                auth().
                preemptive().
                basic(LOGIN, PASSWORD).
                baseUri(SHOP_SERVER_URL).
                get(endpoint);

        return SAMPLE_REST.response;
    }

    public Response sendPostRequest(AddItemToCardRequestPojo body, String endPoint) {
        SAMPLE_REST.response = given().
                auth().
                preemptive().
                basic(LOGIN, PASSWORD).
                contentType("application/json").
                body(body).
                baseUri(SHOP_SERVER_URL).
                post(endPoint);
        return  SAMPLE_REST.response;
    }
}

