package com.dydko.iterator;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Queue1 {

    @Test
    public void queue_1() {

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(20);
        queue.offer(21);
        queue.offer(22);
//        queue.offer(4);
//        queue.offer(16);
//        queue.offer(18);
//        queue.offer(11);
//        queue.offer(12);

        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println("size: " + queue.size());

        System.out.println("---------------------");
        //System.out.println(queue.peek());
    }
}
