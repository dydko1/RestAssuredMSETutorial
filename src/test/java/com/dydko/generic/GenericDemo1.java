package com.dydko.generic;

import org.junit.jupiter.api.Test;

public class GenericDemo1 {

    @Test
    public void genericDemo1() {
        String[] strings = {"one", "two", "three"};
        Integer[] integers = {1, 2, 3, 4};

        printArray(strings);
        printArray(integers);
    }

    private <E> void printArray(E[] tab) {
        for (E e1 : tab) {
            System.out.println("list element val: " + e1);
        }
    }
}
