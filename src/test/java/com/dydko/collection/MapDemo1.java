package com.dydko.iterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class MapDemo1 {

    @Test
    public void map_1() {

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(10, "one");
        map1.put(2, "two");
        map1.put(3, "three");

        for (Integer i : map1.keySet()) {
            System.out.println("key: " + i);
        }
        System.out.println("-----------------------------------------");
        for (Map.Entry<Integer, String> entry : map1.entrySet()) {
            System.out.println("k=" + entry.getKey() + " ,v=" + entry.getValue());

        }

    }
}
