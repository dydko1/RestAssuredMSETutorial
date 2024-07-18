package lesson.romannumber;

import org.testng.annotations.Test;

public class Roman1 {

    private static final String ROMAN_NUMBER = "MCMXCIV";

    @Test
    public void getNumeral() {
        System.out.println("Zapis dzisiętny case.: " + getNumber());
    }

    private Integer getNumber() {
        Integer sum=0;
        char[] romanChar = ROMAN_NUMBER.toCharArray();
        for (char c : romanChar) {
            sum += getNumber(c);
        }

        return sum;
    }

    private Integer getNumber(char c) {
        return switch (Character.toString(c)) {
            case "I" -> 1;
            case "V" -> 5;
            case "X" -> 10;
            case "L" -> 50;
            case "C" -> 100;
            case "D" -> 500;
            case "M" -> 1000;
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
    }
}