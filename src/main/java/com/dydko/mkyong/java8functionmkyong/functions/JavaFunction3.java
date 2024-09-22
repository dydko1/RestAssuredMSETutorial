package com.dydko.mkyong.java8functionmkyong.functions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class JavaFunction3 {
    public static void main(String[] args) {
        JavaFunction3 obj = new JavaFunction3();

        List<String> list = Arrays.asList("node", "c++", "java", "javascript");
        Map<String, Integer> map = obj.converListToMap(list, String::length);
        System.out.println(map);

    }

    public <T, R> Map<T, R> converListToMap(List<T> list, Function<T, R> func) {
        Map<T, R> res = new HashMap<>();
        for (T t : list) {
            res.put(t, func.apply(t));
        }
        return res;
    }
}