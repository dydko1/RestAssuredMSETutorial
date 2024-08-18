package com.dydko.winterbe.pred1;

import java.util.Optional;

public class Oprt1 {
    public static void main(String[] args) {

        Optional<String> optional = Optional.of("test123");

        System.out.println(optional.isPresent());
        System.out.println(optional.get());
        System.out.println(optional.orElse("Ddd"));
    }
}
