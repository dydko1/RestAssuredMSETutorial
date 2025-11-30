package com.dydko.gorest.test1;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public abstract class GoRestBaseTest {

    protected static String TOKEN;

    @BeforeAll
    static void globalSetUp() throws IOException {
        // wspólna baza dla wszystkich testów GoRest
        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        Properties properties = new Properties();
        try (InputStream is = GoRestBaseTest.class
                .getResourceAsStream("/gorest.properties")) {

            assertNotNull(is, "Brak pliku gorest.properties w src/test/resources");
            properties.load(is);
        }

        TOKEN = properties.getProperty("gorest.token");
        assertNotNull(TOKEN, "Brak wpisu gorest.token w gorest.properties");
    }
}
