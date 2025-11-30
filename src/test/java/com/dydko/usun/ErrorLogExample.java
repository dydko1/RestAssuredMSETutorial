package com.dydko.usun;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ErrorLogExample {
    public static void main(String[] args) {
        List<String> logs = List.of(
                "E001:Pierwszy błąd",
                "E002:Coś tam",
                "E001:Ten sam błąd, inny opis 2",
                "E003:Inny błąd",
                "E001:Ten sam błąd, inny opis 3",
                "E001:Ten sam błąd, inny opis 4"
        );

        Map<String, String> firstErrorMessages = logs.stream()
                .map(l -> l.split(":", 2))
                .collect(Collectors.toMap(
                        p -> p[0],
                        p -> p[1],
                        (o, n) -> n,
                        LinkedHashMap::new
                ));
        firstErrorMessages.forEach((code, message) ->
                System.out.println(code + " = " + message));
    }
}
