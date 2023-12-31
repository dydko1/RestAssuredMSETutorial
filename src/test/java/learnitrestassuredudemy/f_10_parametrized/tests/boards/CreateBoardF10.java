package learnitrestassuredudemy.f_10_parametrized.tests.boards;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import learnitrestassuredudemy.f_10_parametrized.tests.BaseTest_F_10;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Map;

import static learnitrestassuredudemy.f_10_parametrized.consts.BoardsEndpoints.*;
import static learnitrestassuredudemy.f_10_parametrized.consts.UrlParamValues.PATH_MEMBER_PARAMS;

public class CreateBoard extends BaseTest_F_10 {

    private String createdBoardId;

    @Test
    public void checkCreateBoard() {
        String boardName = "Miro - New Board: " + LocalDateTime.now();
        Response response = requestWithAuth()
                .body(Map.of("name", boardName))
                .contentType(ContentType.JSON)
                .post(CREATE_BOARD_URL);
        createdBoardId = response.body().jsonPath().get("id");

        response
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", Matchers.equalTo(boardName));

        requestWithAuth()
                .pathParams(PATH_MEMBER_PARAMS)
                .get(GET_ALL_BOARDS_URL)
                .then()
                .body("name", Matchers.hasItem(boardName));
    }

    @AfterEach
    public void deleteCreatedBoard() {
        requestWithAuth().pathParams("id", createdBoardId)
                .delete(DELETED_BOARD_URL)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}