package learnitrestassuredudemy.f_10_parametrized.tests.cards;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import learnitrestassuredudemy.f_10_parametrized.arguments.holders.AuthValidationArgumentsHolder1;
import learnitrestassuredudemy.f_10_parametrized.arguments.holders.CardBodyValidationArgumentsHolder;
import learnitrestassuredudemy.f_10_parametrized.arguments.providers.AuthValidationArgumentsProvider1;
import learnitrestassuredudemy.f_10_parametrized.arguments.providers.CardBodyValidationArgumentsProvider;
import learnitrestassuredudemy.f_10_parametrized.tests.BaseTest_F_10;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Map;

import static learnitrestassuredudemy.f_10_parametrized.consts.BoardsEndpoints.CREATE_CARD_URL;
import static learnitrestassuredudemy.f_10_parametrized.consts.UrlParamValues.ANOTHER_USER_AUTH_QUERY_PARAMS;
import static learnitrestassuredudemy.f_10_parametrized.consts.UrlParamValues.EXISTING_LIST_ID;

public class CreateCardValidationTestF13 extends BaseTest_F_10 {
    @ParameterizedTest
    @ArgumentsSource(CardBodyValidationArgumentsProvider.class)
    public void checkCreateCardWithInvalidName(CardBodyValidationArgumentsHolder validationArguments) {
        Response response = requestWithAuth()
                .body(validationArguments.getBodyParams())
                .contentType(ContentType.JSON)
                .post(CREATE_CARD_URL);
        response
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
        Assertions.assertEquals(validationArguments.getErrorMessage(), response.body().asString());
    }

    @ParameterizedTest
    @ArgumentsSource(AuthValidationArgumentsProvider1.class)
    public void checkCreateCardWithInvalidAuth(AuthValidationArgumentsHolder1 validationArguments) {
        Response response = requestWithoutAuth()
                .queryParams(validationArguments.getAuthParams())
                .body(Map.of(
                        "name", "New item",
                        "idList", EXISTING_LIST_ID
                ))
                .contentType(ContentType.JSON)
                .post(CREATE_CARD_URL);
        response
                .then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
        Assertions.assertEquals(validationArguments.getErrorMessage(), response.body().asString());
    }

    @Test
    public void checkCreateCardWithAnotherUserCredentials() {
        Response response = requestWithoutAuth()
                .queryParams(ANOTHER_USER_AUTH_QUERY_PARAMS)
                .body(Map.of(
                        "name", "New item",
                        "idList", EXISTING_LIST_ID
                ))
                .contentType(ContentType.JSON)
                .post(CREATE_CARD_URL);
        response
                .then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
        Assertions.assertEquals("invalid token", response.body().asString());
    }
}