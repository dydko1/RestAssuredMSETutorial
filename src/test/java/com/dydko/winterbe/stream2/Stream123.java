package com.dydko.winterbe.stream2;

import java.util.stream.Stream;

public class Stream123 {
    public static void main(String[] args) {

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("foreach: " + s));
    }
}
