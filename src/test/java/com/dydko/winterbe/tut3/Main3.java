package com.dydko.winterbe.tut3;

public class Main3 {
    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person p1 = personFactory.create("Miro", "Dydko", 40);
        System.out.println(p1);
    }
}
