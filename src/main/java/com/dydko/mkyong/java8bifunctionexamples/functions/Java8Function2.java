package com.dydko.mkyong.java8bifunctionexamples.functions;

import java.util.function.Function;

public class Java8Function2 {
    public static void main(String[] args) {
        Function<String, Integer> func = String::length;
        Function<Integer, Integer> func2 = x -> x * x;

        Integer res = func.andThen(func2).apply("abc");
        System.out.println(res);
    }
}