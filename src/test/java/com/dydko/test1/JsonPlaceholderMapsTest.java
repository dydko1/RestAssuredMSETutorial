package com.dydko.test1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JsonPlaceholderMapsTest {

    private static List<Map<String, Object>> users;

    private static Map<Integer, String> idToName;
    private static Map<String, String> usernameToEmail;
    private static Map<Integer, Map<String, Object>> idToUser;


    @BeforeAll
    static void loadUsersAndBuildMaps() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = RestAssured.given()
                .log().uri()
                .when()
                .get("/users")
                .then()
                .log().status()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        users = response
                .jsonPath()
                .getList("$");
        assertEquals(10, users.size(), "Powinno być 10 userów");

        idToName = new HashMap<>();
        usernameToEmail = new HashMap<>();
        idToUser = new HashMap<>();
        users.forEach(u -> {
                    Integer id = ((Number) u.get("id")).intValue();
                    String name = (String) u.get("name");
                    String username = (String) u.get("username");
                    String email = (String) u.get("email");
                    idToName.put(id, name);             // 1) id -> name
                    usernameToEmail.put(username, email); // 2) username -> email
                    idToUser.put(id, u);
                }
        );

    }

    @Test
    void idToName_shouldContainTenEntriesAndUser1() {
        assertEquals(10, idToName.size());

        String user1Name = idToName.get(1);
        assertNotNull(user1Name);

        System.out.println("idToName = " + idToName);
        System.out.println("User 1 name = " + user1Name);
    }

    @Test
    void usernameToEmail_shouldReturnEmailForBret() {
        String email = usernameToEmail.get("Bret");
        assertNotNull(email);
        System.out.println("Email dla 'Bret' = " + email);
    }

    @Test
    void idToUser_shouldReturnFullUserObject() {
        Map<String, Object> user3 = idToUser.get(3);
        assertNotNull(user3);
        System.out.println("User 3 full map = " + user3);
    }
}