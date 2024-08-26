package com.dydko.howtodoinjava.a;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Demo1 {

    @Test
    void contains1(){
        List<Car> cars = Arrays.asList(
                new Car("Dacia", "diesel", 100),
                new Car("Lexus", "gasoline", 300),
                new Car("Ford", "electric", 200)
        );

        Car car1 = new Car("Dacia", "diesel", 100);  //Present in original list
        Car car2 = new Car("Ford", "electric", 80);
        Car car3 = new Car("Chevrolet", "electric", 150);
    }
}
