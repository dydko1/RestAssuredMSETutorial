package com.dydko.pokeapi;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

class PokeApiPokemonDetailsTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://pokeapi.co/api/v2";
    }

    @Test
    void shouldMapPikachuStatsAndTypes() {
        PokemonResponse pikachu = given()
                .log().uri()
                .when()
                .get("/pokemon/pikachu")
                .then()
                .log().status()
                .statusCode(200)
                .extract()
                .as(PokemonResponse.class);

        assertEquals("pikachu", pikachu.getName());
        assertEquals(25, pikachu.getId());

        // 1) Map<String, Integer> statName -> baseStat
        Map<String, Integer> statNameToBaseStat = new HashMap<>();
        pikachu.getStats().forEach(statWrapper -> {
            String statName = statWrapper.getStat().getName();
            Integer baseStat = statWrapper.getBase_stat();
            statNameToBaseStat.put(statName, baseStat);
        });

        System.out.println("Staty Pikachu:");
        statNameToBaseStat.forEach((name, value) ->
                System.out.println(name + " -> " + value));

        assertTrue(statNameToBaseStat.containsKey("speed"));
        assertTrue(statNameToBaseStat.get("speed") > 0);

        // 2) Lista typów (electric itd.)
        System.out.println("Typy Pikachu:");
        pikachu.getTypes().forEach(tw ->
                System.out.println("slot " + tw.getSlot() + " -> " + tw.getType().getName()));

        assertFalse(pikachu.getTypes().isEmpty());
    }
}