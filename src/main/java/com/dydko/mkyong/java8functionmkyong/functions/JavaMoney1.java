package com.dydko.mkyong.java8functionmkyong.functions;

import java.util.function.Function;

public class JavaMoney1 {

    public static void main(String[] args) {

        Function<String, Integer> func = String::length;
        Integer s = func.apply("dddd");
        System.out.println(s);
    }
}