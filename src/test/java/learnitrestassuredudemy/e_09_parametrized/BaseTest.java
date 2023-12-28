package learnitrestassuredudemy.e_09_parametrized;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;

public class BaseTest {
    @BeforeAll
    public static void setBaseUrl() {
        RestAssured.baseURI = "https://api.trello.com/1";
    }
    protected RequestSpecification requestWithAuth() {
        return requestWithoutAuth()
                .queryParams(Map.of(
                        "key", "6f04eeee897329faa9261fe2bca35a0b",
                        "token", "ATTA2b88bae9dfa84e8ac67cbc393c8b8468cda406428d9f3c3e43e5cd72765a2d6411212F83"
                ));
    }

    protected RequestSpecification requestWithoutAuth() {
        return RestAssured.given();
    }
}
