package com.dydko.winterbe.stream2;

import java.util.stream.IntStream;

public class Sum1233 {
    public static void main(String[] args) {
        IntStream
                .range(1, 5 + 1)
                .forEach(System.out::println);
    }
}
