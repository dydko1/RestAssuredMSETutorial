package com.dydko.java8bifunctionexamples.introduce;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Java8BiFunction1 {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> func = Integer::sum;
        Integer res = func.apply(20, 21);
        System.out.println(res);

        BiFunction<Integer, Integer, Double> func2 = Math::pow;
        System.out.println(func2.apply(2, 3));

        BiFunction<Integer, Integer, List<Integer>> func3 = (x1, x2) -> Arrays.asList(x1 + x2, x1 * x2);
        List<Integer> res3 = func3.apply(10, 50);
        System.out.println(res3);
    }
}