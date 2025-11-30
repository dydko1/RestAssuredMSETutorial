package com.dydko.dummyjson;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class DummyJsonProductsMapsTest {
    private static List<Map<String, Object>> products;

    private static Map<Integer, String> idToTitle;
    private static Map<String, Double> titleToPrice;
    private static Map<String, List<String>> categoryToTitles;


    @BeforeAll
    static void loadProductsAndBuildMaps() {
        RestAssured.baseURI = "https://dummyjson.com";

        Response response = given()
                .log().uri()
                .when()
                .get("/products")
                .then()
                .log().status()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        products = response.jsonPath().getList("products");
        assertFalse(products.isEmpty(), "Lista products nie powinna być pusta");

        idToTitle = new HashMap<>();
        titleToPrice = new HashMap<>();
        categoryToTitles = new HashMap<>();

        products.forEach((product) -> {
            Integer id = ((Number) product.get("id")).intValue();
            String title = (String) product.get("title");
            Number priceNumber = (Number) product.get("price");
            double price = priceNumber.doubleValue();
            String category = (String) product.get("category");

            // 1) id -> title
            idToTitle.put(id, title);

            // 2) title -> price
            titleToPrice.put(title, price);

            // 3) category -> lista titles
            categoryToTitles
                    .computeIfAbsent(category, c -> new ArrayList<>())
                    .add(title);
        });
    }

    @Test
    void idToTitle_shouldContainSomeProducts() {
        assertFalse(idToTitle.isEmpty());
        System.out.println("idToTitle = " + idToTitle);

        // przykładowy check: pierwszy product (id=1) istnieje
        assertNotNull(idToTitle.get(1));
    }

    @Test
    void titleToPrice_shouldContainConsistentPrices() {
        assertFalse(titleToPrice.isEmpty());
        titleToPrice.forEach((title, price) -> {
            assertTrue(price > 0, "Cena powinna być > 0 dla " + title);
        });

        System.out.println("titleToPrice sample: ");

        titleToPrice.entrySet().stream()
                .limit(5)
                .forEach(e -> System.out.println("  " + e.getKey() + " -> " + e.getValue()));
    }
}