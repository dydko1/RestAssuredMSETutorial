package com.dydko.cheatsheetonjavacollection.array1;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class LinkedListDemo1 {

    @Test
    public void linkedListDemo1() {
        // Basic initialization
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("A"); // appends the value in the linked list
        linkedList.add("B");
        linkedList.add("C");
        linkedList.poll();
        linkedList.poll();
        linkedList.poll();
        linkedList.poll();
        //linkedList.remove();

        System.out.println(linkedList);

    }
}
