package learnitrestassuredudemy.f_10_parametrized.tests.cards;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import learnitrestassuredudemy.f_10_parametrized.tests.BaseTest_F_10;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterTest;

import java.time.LocalDateTime;
import java.util.Map;

import static learnitrestassuredudemy.f_10_parametrized.consts.BoardsEndpoints.*;
import static learnitrestassuredudemy.f_10_parametrized.consts.UrlParamValues.EXISTING_LIST_ID;

public class CreateCardTestF11 extends BaseTest_F_10 {
    private String createdCardId;

    @Test
    public void checkCreateCard() {
        String cardName = String.format("Miro - New Card: %s", LocalDateTime.now());
        Response response = requestWithAuth()
                .body(Map.of(
                        "name", cardName,
                        "idList", EXISTING_LIST_ID))
                .contentType(ContentType.JSON)
                .post(CREATE_CARD_URL);
        createdCardId = response.body().jsonPath().get("id");

        response
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", Matchers.equalTo(cardName));

        requestWithAuth()
                .queryParams("fields", "id,name")
                .pathParams("list_id",EXISTING_LIST_ID)
                .get(GET_ALL_CARDS_URL)
                //.prettyPeek()
                .then()
                .body("name",Matchers.hasItem(cardName));
    }

    @AfterEach
    public void deleteCard(){
        requestWithAuth()
                .pathParams("id",createdCardId)
                .delete(DELETE_CARD_URL)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}