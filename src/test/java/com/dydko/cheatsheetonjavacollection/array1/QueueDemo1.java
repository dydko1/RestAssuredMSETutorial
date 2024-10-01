package com.dydko.cheatsheetonjavacollection.array1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo1 {

    @Test
    public void queueDemo1() {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(11, 2, 3, 4, 8, -4));
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        queue.add(2434);
        System.out.println(queue);
    }
}
