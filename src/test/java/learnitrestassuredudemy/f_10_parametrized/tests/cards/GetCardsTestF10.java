package learnitrestassuredudemy.f_10_parametrized.tests.cards;

import io.restassured.module.jsv.JsonSchemaValidator;
import learnitrestassuredudemy.f_10_parametrized.tests.BaseTest_F_10;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class GetCardsTestF10 extends BaseTest_F_10 {

    @Test
    public void checkGetCards() {
        requestWithAuth()
                .queryParams("fields", "id,name")
                .pathParam("list_id", "657d3e2859348b240137e17c")
                .get("/lists/{list_id}/cards")
                .prettyPeek()
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/get_cards.json"));
    }

    @Test
    public void checkGetCard() {
        requestWithAuth()
                .queryParams("fields", "id,name")
                .pathParam("id", "657d44e657ba982cad2fa2ab")
                .get("/cards/{id}")
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/get_card.json"))
                .body("name", Matchers.equalTo("Test198111111111111111111111111111111111111111111111111111"));
    }
}