package com.dydko.cheatsheetonjavacollection.array1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapDemo1 {

    @Test
    public void queueDemo1() {

        Map<String, String> map1 = new HashMap<>();
        map1.put("aa","123");
        map1.put("bb","234344");
        //map1.keySet();
        //map1.keySet()
        List<String> listKey = new ArrayList<>(map1.keySet()); // make list
        List<String> listVal= new ArrayList<>(map1.values()); // make list
        System.out.println(listKey);
        System.out.println(listVal);

//
//        for (int i = 0; i < mapArray.length; i++) {
//            mapArray[i] = new HashMap<>();
//            mapArray[i].put( String.valueOf(i), "val_" + i);
//        }
//
//        for (int i = 0; i < mapArray.length; i++) {
//            System.out.println(mapArray[i].get(String.valueOf(i)));
//        }
    }
}
