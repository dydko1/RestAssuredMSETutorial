package com.dydko.winterbe.tut1;

public class FormulaImpl implements Formula{

    @Override
    public double calculate(int a) {
        return 0;
    }

    @Override
    public double sqrt(int a) {
        return Formula.super.sqrt(a);
    }
}
