package com.dydko.winterbe.stream2;

import java.util.stream.Stream;

public class Ave1 {
    public static void main(String[] args) {
        Stream.of("a1", "a2", "a9", "a3")
                .map(s -> s.substring(1))
                .mapToInt(i1 -> Integer.valueOf(i1))
                .max()
                .ifPresent(s -> System.out.println(s));
    }
}
