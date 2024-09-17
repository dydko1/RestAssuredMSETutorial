package com.dydko.java8bifunctionexamples;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Java8BiFunction2c {

    public static void main(String[] args) {

        String res1 = converter(2, 4, (p1, p2) -> Math.pow(p1, p2), r -> "Res: " + r);
        System.out.println(res1);

        String res2 = converter(10, 20, (p1, p2) -> p1 * p2, s -> "Res: " + s);
        System.out.println(res2);

        String res3 = converter("axx", "bbb", (p1, p2) -> p1 + "\t" + p2, s -> "Wynik: " + s);
        System.out.println(res3);

        String res4=converter("100","200",(a1,a2)->a1+a2, r->"Wynik2: "+r);
    }

    public static <A1, A2, R1, R2> R2 converter(A1 a1, A2 a2,
                                                BiFunction<A1, A2, R1> func1,
                                                Function<R1, R2> func2) {
        return func1.andThen(func2).apply(a1, a2);
    }
}