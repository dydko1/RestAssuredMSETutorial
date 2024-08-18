package com.dydko.winterbe.tut1;

public class Main1 {
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        System.out.println(formula.calculate(9));
        System.out.println(formula.sqrt(16));
    }
}