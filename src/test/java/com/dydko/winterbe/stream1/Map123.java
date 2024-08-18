package com.dydko.winterbe.stream1;

import java.util.HashMap;
import java.util.Map;

public class Map123 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));


        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);             // val33

        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);     // false

        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);    // true

        map.computeIfAbsent(3, num -> "bam");
        map.put(2, "ddddddddddd");
        map.get(3);             // val33

        System.out.println("------------------");
        map.forEach((i1, s1) -> System.out.println(s1));
    }
}
