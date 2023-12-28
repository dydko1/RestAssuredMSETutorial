package learnitrestassuredudemy.e_09_parametrized;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class GetCardsTest extends BaseTest {

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