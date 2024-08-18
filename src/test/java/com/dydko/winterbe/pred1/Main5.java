package com.dydko.winterbe.pred1;

import com.dydko.winterbe.tut3.Person;
import com.dydko.winterbe.tut3.PersonFactory;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main5 {
    public static void main(String[] args) {
        Consumer<Person> greeter = person -> {
            System.out.println("Hello.: " + person.getFirstName());
        };
        greeter.accept(new Person("Miro", "Dydko", 45));
//        Supplier<Person> personSupplier = Person::new;
//        System.out.println(personSupplier.get());

//        Predicate<String> stringPredicate = s -> s.length() > 5;
//        System.out.println(stringPredicate.test("ddd"));
//        System.out.println(stringPredicate.negate().test("ddd"));
    }
}
