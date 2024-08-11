package com.dydko.presentinanarray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PresentValue2 {

    private static final int ARRAY_1[] = {5, 1, 1, 9, 7, 2, 6, 10};

    @Test
    public void getValue1() {
        System.out.println(findValue());
    }

    private String findValue() {

        boolean test = IntStream.of(ARRAY_1).anyMatch(x -> x == 7);
        return test
                ? "zawiera" : "nie zawiera";
    }
}