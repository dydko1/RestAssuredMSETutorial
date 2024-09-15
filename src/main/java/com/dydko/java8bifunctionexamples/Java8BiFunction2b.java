package com.dydko.java8bifunctionexamples;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Java8BiFunction2b {
    public static void main(String[] args) {

        String res = powToString(2, 4, Math::pow, s -> "result: " + (s));

        System.out.println(res);
    }

    public static <R> R powToString(Integer a1, Integer a2,
                                    BiFunction<Integer, Integer, Double> func,
                                    Function<Double, R> func2) {

        return func
                .andThen(func2)
                .apply(a1, a2);
    }
}