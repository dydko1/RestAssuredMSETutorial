package com.dydko.winterbe.pred1;

import java.util.function.Function;

public class Main6 {
    public static void main(String[] args) {

        Function<String, Integer> toInteger = Integer::valueOf;
        System.out.println(toInteger.apply("1222133"));

        Function<String, String> backToString = toInteger.andThen(s -> String.valueOf(s));
        System.out.println(backToString.apply("99950"));
    }
}