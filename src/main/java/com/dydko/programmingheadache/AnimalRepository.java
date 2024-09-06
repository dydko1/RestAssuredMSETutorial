package com.dydko.programmingheadache;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@NoArgsConstructor
public class AnimalRepository {

    public Stream<Animal> getAnimals() {
        List<Animal> animals = Arrays.asList(
                new Animal("Lion", "Mammal", 190.0, 3.5),
                new Animal("Elephant", "Mammal", 5000.0, 10.0),
                new Animal("Penguin", "Bird", 1.5, 0.5),
                new Animal("Snake", "Reptile", 10.0, 1.0),
                new Animal("Dolphin", "Mammal", 300.0, 2.0),
                new Animal("Eagle", "Bird", 5.0, 0.8),
                new Animal("Tiger", "Mammal", 250.0, 3.0),
                new Animal("Crocodile", "Reptile", 150.0, 2.5),
                new Animal("Giraffe", "Mammal", 1200.0, 5.5),
                new Animal("Hawk", "Bird", 2.0, 0.6),
                // Duplicated hawk
                new Animal("Hawk", "Bird", 2.5, 0.6)
        );

        return animals.stream();
    }
}