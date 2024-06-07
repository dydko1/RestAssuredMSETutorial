package learnitrestassuredudemy1.c003_post;

import learnitrestassuredudemy1.a_consts.BoardsEndpoints;
import learnitrestassuredudemy1.a_consts.UrlParamValues;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import learnitrestassuredudemy1.b002.BaseTest_001;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Map;

public class CreateBoardTest extends BaseTest_001 {

    private String createdBoardId;

    @Test
    public void checkCreateBoard() {
        String boardName = "New Board" + LocalDateTime.now();
        Response response = requestWithAuth()
                .body(Map.of("name", boardName))
                .contentType(ContentType.JSON)
                .post(BoardsEndpoints.CREATE_BOARD_URL);
        createdBoardId = response.body().jsonPath().get("id");
//        response
//                .then()
//                .statusCode(200)
//                .body("name", Matchers.equalTo(boardName));
        requestWithAuth()
                .pathParam("member", UrlParamValues.USER_NAME)
                .get(BoardsEndpoints.GET_ALL_BOARDS_URL)
                .prettyPeek();
                //.then()
                //.
               // .body("name", Matchers.hasItem(boardName));
    }

//    @AfterEach
//    public void deleteCreatedBoard() {
//        requestWithAuth()
//                .pathParam("id", createdBoardId)
//                .delete(BoardsEndpoints.DELETE_BOARD_URL)
//                .then()
//                .statusCode(200);
//    }
}