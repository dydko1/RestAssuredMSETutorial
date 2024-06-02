package learnitrestassuredudemy1.b002;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static learnitrestassuredudemy1.a_consts.UrlParamValues.AUTH_QUERY_PARAMS;

public class BaseTest_001 {

    @BeforeAll
    public static void setBaseUrl() {
        RestAssured.baseURI = "https://api.trello.com/1";
    }

    protected RequestSpecification requestWithAuth() {
        return RestAssured.given()
                .queryParams(
                        AUTH_QUERY_PARAMS
                );
    }

    protected RequestSpecification requestWithoutAuth() {
        return RestAssured.given();
    }
}