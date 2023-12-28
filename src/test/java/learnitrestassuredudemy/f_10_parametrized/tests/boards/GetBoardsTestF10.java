package learnitrestassuredudemy.f_10_parametrized.tests.boards;

import io.restassured.module.jsv.JsonSchemaValidator;
import learnitrestassuredudemy.f_10_parametrized.tests.BaseTest_F_10;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static learnitrestassuredudemy.f_10_parametrized.consts.BoardsEndpoints.GET_ALL_BOARDS_URL;
import static learnitrestassuredudemy.f_10_parametrized.consts.BoardsEndpoints.GET_BOARD_URL;
import static learnitrestassuredudemy.f_10_parametrized.consts.UrlParamValues.*;

public class GetBoardsTestF10 extends BaseTest_F_10 {

    @Test
    public void checkGetBoards() {
        requestWithAuth()
                .queryParams(QUERY_PARAMS)
                .pathParams(PATH_MEMBER_PARAMS)
                .get(GET_ALL_BOARDS_URL)
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/get_boards.json"));
    }

    @Test
    public void checkBoard() {
        requestWithAuth()
                .queryParams(QUERY_PARAMS)
                .pathParams(PATH_ID_BOARD)
                .get(GET_BOARD_URL)
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", Matchers.equalTo("Aktualna tablica"));
    }
}