package com.dydko.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Iterator1 {

    private static final List<Integer> INTEGERS = Arrays.asList(1, 2, 3, 4, 5);
    private static final String TEMPLATE = "Miro: %s";

    @Test
    public void iterator_1() {
        Iterator<Integer> iterator = INTEGERS.iterator();
        while (iterator.hasNext())
            System.out.println(String.format(TEMPLATE, iterator.next()));
            //System.out.println(iterator.next());
    }

    @Test
    public void iterator_remove() {
        Iterator<Integer> iterator = INTEGERS.iterator();
        while (iterator.hasNext())
            iterator.remove(); //exception UnsupportedOperationException
        //System.out.println(iterator.next());
    }

    @Test
    public void iterator_thread() {
        System.out.println("========== Iterator - Fail-safe iterator demo ==========");
        List<Integer> threadSafeList = new CopyOnWriteArrayList<>(INTEGERS);
        Iterator<Integer> iterator = INTEGERS.iterator();
        iterator = threadSafeList.iterator();
        threadSafeList.add(0,20);
        threadSafeList.add(100);

        while (iterator.hasNext()) {
            threadSafeList.remove(0);
            int nextElement = iterator.next();
            System.out.println(nextElement);
        }
        System.out.println(threadSafeList);
    }
}
