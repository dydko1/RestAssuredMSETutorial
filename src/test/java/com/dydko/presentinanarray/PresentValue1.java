package com.dydko.presentinanarray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PresentValue1 {

    private static final Integer ARRAY_1[] = {5, 1, 1, 9, 7, 2, 6, 10};

    @Test
    public void getValue() {

        System.out.println(findValue());
    }

    private String findValue() {
        return Arrays.asList(ARRAY_1).contains(10)
                ? "zawiera" : "nie zawiera";
    }
}