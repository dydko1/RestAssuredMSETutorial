package com.dydko.generic;

import org.junit.jupiter.api.Test;

public class GenericDemo3<T> {

    private T t;

//    public GenericDemo3(T t) {
//        this.t = t;
//    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Test
    public void genericDemo2() {
        GenericDemo3<Integer> integerGenericDemo3 = new GenericDemo3<>();
        GenericDemo3<String> stringGenericDemo3 = new GenericDemo3<>();

        integerGenericDemo3.setT(10);
        stringGenericDemo3.setT("ten");

        Integer int1 = integerGenericDemo3.getT();
        String string1 = stringGenericDemo3.getT();

        System.out.printf("Integer val: %d\n\n%s", int1,"----------");
        System.out.printf("String val: %s\n", string1);
    }
}