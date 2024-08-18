package com.dydko.winterbe.tut2;

@FunctionalInterface
public interface Converter<F, R> {
    R converter(F from);
}