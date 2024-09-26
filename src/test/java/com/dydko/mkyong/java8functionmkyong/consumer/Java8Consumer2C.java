package com.dydko.mkyong.java8functionmkyong.consumer;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8Consumer2C {

    @Test
    void test2() {
        List<String> list = Arrays.asList("a", "bb", "ccc");
        forEach2(list, x -> System.out.println(x.length()));
    }

    private <T> void forEach2(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}