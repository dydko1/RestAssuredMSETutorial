package com.dydko.string2;

public class MainStringChar2 {
    static String str = "GeeksForGeeks";
    static int index = 5;

    public static void main(String[] args) {

        System.out.println("Znak: " + str
                .chars()
                .mapToObj(ch -> (char) ch)
                .toArray(Character[]::new)[3]);
    }
}