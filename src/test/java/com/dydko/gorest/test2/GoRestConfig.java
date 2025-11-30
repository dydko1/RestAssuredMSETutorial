package com.dydko.gorest.test2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public record GoRestConfig(String baseUri, String token) {

    public static GoRestConfig fromProperties(String resourceName) {
        Properties properties = new Properties();

        try (InputStream is = GoRestConfig.class.getResourceAsStream("/" + resourceName)) {
            assertNotNull(is, "Brak pliku " + resourceName + " w src/test/resources");
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Błąd wczytywania " + resourceName, e);
        }

        String baseUri = properties.getProperty("gorest.baseUri", "https://gorest.co.in/public/v2");
        String token = properties.getProperty("gorest.token");

        assertNotNull(token, "Brak wpisu gorest.token w " + resourceName);

        return new GoRestConfig(baseUri, token);
    }
}