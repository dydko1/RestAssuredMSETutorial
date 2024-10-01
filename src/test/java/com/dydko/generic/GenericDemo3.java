package com.dydko.generic;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class GenericDemo2 {

    @Test
    public void genericDemo2() {

//        System.out.printf("Max of %d, %d and %d is %d\n\n", 1, 2, 3,
//                maxVal(1, 2, 3));
//
//        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n",
//                1.1, 2.2, 3.3, maxVal(1.1, 2.2, 3.3));
//
//        System.out.printf("Max of %s, %s and %s is %s\n", "Audi",
//                "Acura", "Aston Martin", maxVal("Audi", "Acura", "Aston Martin"));
        maxOf(15, 2, 3);
        maxOf(10., 2., 3.);
        maxOf("dd", "bb", "cc");

    }

    private <T extends Comparable<T>> void maxOf(T t1, T t2, T t3) {
        System.out.printf("Max of %s, %s and %s is: %s\n\n", t1, t2, t3,
                maxVal(t1, t2, t3));
    }

    private <T extends Comparable<T>> T maxVal(T t1, T t2, T t3) {
        T max = t1;

        if (t2.compareTo(max) > 0) {
            max = t2;
        }

        if (t3.compareTo(max) > 0) {
            max = t3;
        }

        return max;
    }
}
