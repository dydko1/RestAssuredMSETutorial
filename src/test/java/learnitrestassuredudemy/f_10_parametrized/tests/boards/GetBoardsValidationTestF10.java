package learnitrestassuredudemy.f_10_parametrized.tests.boards;

import io.restassured.response.Response;
import learnitrestassuredudemy.f_10_parametrized.arguments.holders.AuthValidationArgumentsHolder;
import learnitrestassuredudemy.f_10_parametrized.arguments.holders.BoardIdValidationArgumentsHolder;
import learnitrestassuredudemy.f_10_parametrized.arguments.providers.AuthValidationArgumentsProvider;
import learnitrestassuredudemy.f_10_parametrized.arguments.providers.BoardIdValidationArgumentsProvider;
import learnitrestassuredudemy.f_10_parametrized.tests.BaseTest_F_10;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static learnitrestassuredudemy.f_10_parametrized.consts.BoardsEndpoints.GET_BOARD_URL;
import static learnitrestassuredudemy.f_10_parametrized.consts.UrlParamValues.*;

public class GetBoardsValidationTestF10 extends BaseTest_F_10 {

    @ParameterizedTest
    @ArgumentsSource(BoardIdValidationArgumentsProvider.class)
    public void checkGetBoardWithInvalidId(BoardIdValidationArgumentsHolder b) {
        Response response = requestWithAuth()
                .pathParams(b.getPathParams())
                .get(GET_BOARD_URL)
                .prettyPeek();
        response
                .then()
                .statusCode(b.getStatusCode());
        Assertions.assertEquals(b.getErrorMessage(), response.body().asString());
    }

    @ParameterizedTest
    @ArgumentsSource(AuthValidationArgumentsProvider.class)
    public void checkGetBoardWithInvalidAuth(AuthValidationArgumentsHolder validationArguments) {
        Response response = requestWithoutAuth()
                .queryParams(validationArguments.getAuthParams())
                .pathParam("id", EXISTING_BOARD_ID)
                .get(GET_BOARD_URL);
        response
                .then()
                .statusCode(401);
        Assertions.assertEquals("unauthorized permission requested", response.body().asString());
    }

    @Test
    public void checkGetBoardWithAnotherUserCredentials() {
        Response response = requestWithoutAuth()
                .queryParams(ANOTHER_USER_AUTH_QUERY_PARAMS)
                .pathParam("id", EXISTING_BOARD_ID)
                .get(GET_BOARD_URL);
        response
                .then()
                .statusCode(401);
    }
}