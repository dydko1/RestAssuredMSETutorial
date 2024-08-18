package com.dydko.winterbe.tut2;

public class Main2 {
    public static void main(String[] args) {

        Converter<String, Integer> converter = s -> Integer.valueOf(s);
        Integer converted = converter.converter("123");
        System.out.println(converted + 30);
    }
}
