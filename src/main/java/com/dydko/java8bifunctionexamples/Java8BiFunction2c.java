package com.dydko.java8bifunctionexamples;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Java8BiFunction2c {

    public static void main(String[] args) {
//https://mkyong.com/java8/java-8-bifunction-examples/
        String res1 = convert(10, 20,
                (x1, x2) -> Math.pow(x1, x2),
                (s) -> "Wynik: " + s);

        System.out.println(res1);

    }

    public static <A1, A2, R1, R2> R2 convert(A1 a1, A2 a2,
                                              BiFunction<A1, A2, R1> func,
                                              Function<R1, R2> func2) {

        return func
                .andThen(func2)
                .apply(a1, a2);

    }
}