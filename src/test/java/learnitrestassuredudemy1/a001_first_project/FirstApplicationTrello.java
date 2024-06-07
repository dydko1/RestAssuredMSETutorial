package learnitrestassuredudemy1.a001_first_project;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class FirstApplicationTrello {

    @BeforeTest
    public static void setBaseUrl() {
        RestAssured.baseURI = "https://api.trello.com/1";
    }

    @Test
    public void getMember() {
        RestAssured.given()
                .queryParams(
                        "key", "6f04eeee897329faa9261fe2bca35a0b",
                        "token", "ATTA2b88bae9dfa84e8ac67cbc393c8b8468cda406428d9f3c3e43e5cd72765a2d6411212F83"
                )
                .pathParams("member", "miroslawdyduch")
                //.log().all()
                .get("/members/{member}/boards")
                //.prettyPeek()
                .then()
                //extract().jsonPath().getString("name");
                .statusCode(HttpStatus.SC_OK);
        //.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/get_board.json"));
        //.body("name", Matchers.equalTo("Aktualna tablica"));
    }


    @Test
    public void getMemberBoardsIds() {
        String s = RestAssured.given()
                .queryParams(
                        "key", "6f04eeee897329faa9261fe2bca35a0b",
                        "token", "ATTA2b88bae9dfa84e8ac67cbc393c8b8468cda406428d9f3c3e43e5cd72765a2d6411212F83"
                )
                .pathParams("member", "miroslawdyduch")
                //.log().all()
                .get("/members/{member}/boards")
                //.prettyPeek()
                .then()
//                .extract().jsonPath().getString("name");
                .extract().jsonPath().getString("id");
        System.out.println(s);
        //.statusCode(HttpStatus.SC_OK);
        //.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/get_board.json"));
        //.body("name", Matchers.equalTo("Aktualna tablica"));
    }

    @Test
    public void getBoard() {
        Response r = RestAssured.given()
                .queryParams(
                        "key", "6f04eeee897329faa9261fe2bca35a0b",
                        "token", "ATTA2b88bae9dfa84e8ac67cbc393c8b8468cda406428d9f3c3e43e5cd72765a2d6411212F83"
                )
                .pathParams("id", "657d413256de270c186b014d")
                .log().all()
                .get("/boards/{id}");

        r.then().extract().response().prettyPeek();
        //.statusCode(HttpStatus.SC_OK);
        //.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/get_board.json"));
        //.body("name", Matchers.equalTo("Aktualna tablica"));
    }
    @Test
    public void getMemberBoardsIds2() {
         RestAssured.given()
                .queryParams(
                        "key", "6f04eeee897329faa9261fe2bca35a0b",
                        "token", "ATTA2b88bae9dfa84e8ac67cbc393c8b8468cda406428d9f3c3e43e5cd72765a2d6411212F83",
                         "fields", "id,name")
                .pathParams("member", "miroslawdyduch")
                //.log().all()
                .get("/members/{member}/boards")
                .prettyPrint();
                //.then();
//                .extract().jsonPath().getString("name");
                //.extract().jsonPath().getString("id");
        //System.out.println(s);
        //.statusCode(HttpStatus.SC_OK);
        //.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/get_board.json"));
        //.body("name", Matchers.equalTo("Aktualna tablica"));
    }

}
