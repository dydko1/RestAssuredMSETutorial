package com.dydko.mkyong.java8functionmkyong.consumer;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8Consumer2B {

    @Test
    public void consumer2() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Consumer<Integer> consumer1 = (Integer x) -> System.out.println(x);
        forEach1(list,consumer1);
   }

    private <T> void forEach1(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}