package com.dydko.mkyong.java8bifunctionexamples.factory;

import java.util.function.BiFunction;

public class Java8BiFunction3 {

    public static void main(String[] args) {

        GPS1 gps = factory("aaa", "bbbb", GPS1::new);
        System.out.println(gps);
    }

    public static <R extends GPS1> R factory(String l1, String l2,
                                             BiFunction<String, String, R> func) {
        return func.apply(l1, l2);
    }
}