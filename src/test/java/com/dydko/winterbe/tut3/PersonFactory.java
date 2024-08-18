package com.dydko.winterbe.tut3;

public interface PersonFactory<P1 extends Person> {
    P1 create(String f, String l, Integer a);
}
