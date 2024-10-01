package com.dydko.cheatsheetonjavacollection.array1;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo1 {

    @Test
    public void linkedListDemo1() {
        Set<String> set = new HashSet<>();

        set.size();
        set.add("avv");
        set.add("fdsfds");
        set.add("fdsfds");
        set.add("fdsfds");set.add("fdsfds");
        set.add("a");
        //set.contains()
        //set.remove(Object set) // Removes the element from this set if it's present.

        //set.clear();
        //set.isEmpty();

// Looping through
        for (String s : set) {
            System.out.println(s);
        }
    }
}
