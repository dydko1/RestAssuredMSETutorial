package lesson.romannumber;

import org.testng.annotations.Test;

import java.util.Map;

public class Roman {

    private static Map<String, Integer> romanNumbers = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000
    );

    private static final String ROMAN_NUMBER = "MCMXCIV";

    @Test
    public void getNumeral() {
        System.out.println("Zapis dzisiętny.: " + getNumber());
    }

    private Integer getNumber() {
        Integer sum = 0;
        char[] romanChar = ROMAN_NUMBER.toCharArray();
        for (char c : romanChar) {
            sum += romanNumbers.get(Character.toString(c));
        }

        return sum;
    }

//    private Integer getNumber() {
//        Integer sum = 0;
//        for (int i = 0; i < ROMAN_NUMBER.length(); i++) {
//            sum += romanNumbers.get(String.valueOf(ROMAN_NUMBER.charAt(i)));
//        }
//        return sum;
//    }
}
