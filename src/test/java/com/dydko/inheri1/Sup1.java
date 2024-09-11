package com.dydko.inheri1;

public class Sup1 {

    private String locator;

    public Sup1(String locator) {
        this.locator = locator;
    }

    public void displayText(String va1, String var2) {
        System.out.println("super: " + locator + " var1: " + va1 + " var2: " + var2);
    }
}