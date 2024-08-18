package com.dydko.winterbe.pred1;

import com.dydko.winterbe.tut3.Person;

import java.util.Comparator;

public class Compa1 {
    public static void main(String[] args) {

        Comparator<Person> comparator1 = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

        Person p1 = new Person("Miro", "Dydok", 123);
        Person p2 = new Person("Miro2", "Dydko2", 321);

        System.out.println(comparator1.compare(p1, p2));
        System.out.println(comparator1.reversed().compare(p1, p2));
    }
}
