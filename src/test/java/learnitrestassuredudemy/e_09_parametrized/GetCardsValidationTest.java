package learnitrestassuredudemy.e_09_parametrized;

import io.restassured.response.Response;
import learnitrestassuredudemy.e_09_parametrized.arguments.CardIdValidationArgumentsHolder;
import learnitrestassuredudemy.e_09_parametrized.arguments.CardIdValidationArgumentsProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Map;

public class GetCardsValidationTest extends BaseTest {

    @ParameterizedTest
    @ArgumentsSource(CardIdValidationArgumentsProvider.class)
    public void checkGetCardWithInvalidId(CardIdValidationArgumentsHolder validationArguments) {
        Response response = requestWithAuth()
                .pathParams(validationArguments.getPathParams())
                .get("/cards/{id}");
        response
                .then()
                .statusCode(validationArguments.getStatusCode());
        Assertions.assertEquals(validationArguments.getErrorMessage(), response.body().asString());
    }

    @Test
    public void checkGetCardWithInvalidAuth() {
        Response response = requestWithoutAuth()
                .pathParam("id", "657d42d6bdf74a8a04dce102")
                .get("/cards/{id}");
        response
                .then()
                .statusCode(401);
        Assertions.assertEquals("unauthorized card permission requested", response.body().asString());
    }

    @Test
    public void checkGetCardWithAnotherUserCredentials() {
        Response response = requestWithoutAuth()
                .queryParams(Map.of(
                        "key", "6f04eeee897329faa9261fe2bca35a0b",
                        "token", "ATTA2b88bae9dfa84e8ac67cbc393c8b8468cda406428d9f3c3e43e5cd72765a2d6411212F83_BAD_TOKEN"
                ))
                .pathParam("id", "657d42d6bdf74a8a04dce102")
                .get("/cards/{id}");
        response
                .then()
                .statusCode(401);
        Assertions.assertEquals("invalid app token", response.body().asString());
    }
}