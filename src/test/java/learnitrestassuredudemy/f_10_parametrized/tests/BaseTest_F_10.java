package learnitrestassuredudemy.f_10_parametrized.tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import static learnitrestassuredudemy.f_10_parametrized.consts.UrlParamValues.AUTH_QUERY_PARAMS;
import static learnitrestassuredudemy.f_10_parametrized.consts.UrlParamValues.BASE_URI;

public class BaseTest_F_10 {

    @BeforeAll
    public static void setBaseUrl() {
        RestAssured.baseURI = BASE_URI;
    }

    protected RequestSpecification requestWithAuth() {
        return requestWithoutAuth()
                .queryParams(AUTH_QUERY_PARAMS);
    }

    public RequestSpecification requestWithoutAuth() {
        return RestAssured.given();
    }
}
