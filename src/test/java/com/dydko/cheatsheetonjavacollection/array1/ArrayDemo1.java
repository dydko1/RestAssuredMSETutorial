package com.dydko.cheatsheetonjavacollection.array1;

import com.dydko.generic.GenericDemo3;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayDemo1 {

    @Test
    public void arrayDemo1() {
        int[] arr1 = new int[20];
        int[] arr2 = {1, 2, 3, 4, 5, 6,};

        int[][] arr2D1 = new int[10][10];
        int[][] arr2D2 = {{1, 2, 3,}, {10, 20, 30,}};

        int[] arr12 = new int[24];
        Arrays.fill(arr12, 520);
        //System.out.println(arr12[2]);

//        String[] strings = {"Hello", "World"};
//        StringBuilder rev = new StringBuilder();
//        for (int i = strings.length; i > 0; i--) {
//            rev.append(strings[i - 1]).append("!X!");
//        }
//        System.out.println(rev);

        System.out.println(arr2D2[1][0]);
    }
}
