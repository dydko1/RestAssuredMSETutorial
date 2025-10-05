package base

import org.apache.http.HttpStatus
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

class GetCardsTest extends TrelloTest {

    @Test
    public void checkGetCards() {
        requestWithAuth()
                .pathParam("id", "67f7645f2d9626d21ecfa3bf")
                .get("/boards/{id}")
                .then()
                .statusCode(200)
                .body("name", Matchers.equalTo("task_4_Miro1111"));
    }

    @Test
    public void checkGetCardsOnBoard() {
        requestWithAuth()
                .pathParam("id", "67f770994b54fa5881ebb653")
                .get("/boards/{id}/cards")
                .prettyPrint()
    }

    @Test
    public void checkGetCards1() {
        requestWithAuth()
                .pathParam("list_id", "67f770994b54fa5881ebb73b")
                .when()
                .get("/lists/{list_id}/cards")
                .then()
                .statusCode(HttpStatus.SC_OK);
                //.prettyPrint()
    }
}
