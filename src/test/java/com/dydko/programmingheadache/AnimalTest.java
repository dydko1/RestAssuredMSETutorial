package com.dydko.programmingheadache;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.dydko.programmingheadache.Main.print;

public class AnimalTest {

    private final AnimalRepository animalRepository;

    public AnimalTest() {
        this.animalRepository = new AnimalRepository();
    }

    @Test
    public void printAnimals() {
        animalRepository.getAnimals().forEach(System.out::println);
    }

    @Test
    public void printAnimals1() {
        animalRepository.getAnimals().forEach(i -> println1(i.getName() + "xxxx"));
    }

    @Test
    public void getBirds() {
        List<Animal> birds = animalRepository
                .getAnimals()
                .filter(i -> i.getType().equals("Bird"))
                .collect(Collectors.toList());
        System.out.println(birds);
    }

    @Test
    public void getFirstAnimal() {
        Optional<Animal> animal = animalRepository
                .getAnimals()
                .filter(s -> s.getName().equals("Hawk"))
                .findFirst();

        if (animal.isPresent())
            System.out.println(animal.get());
    }

    public <T> void println1(T object) {
        System.out.println("test 123: " + object.toString());
    }
}
