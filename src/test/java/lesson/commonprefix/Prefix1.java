package lesson.commonprefix;

import org.testng.annotations.Test;

public class Prefix1 {
    String[] prefix = {"mirrosghhkjgk", "mirro", "mirrosfsdfdsf", "mirrot23"};

    @Test
    public void test() {
        System.out.println(getPrefix());
    }

    private String getPrefix() {
        int nPrefixElements = prefix.length;
        int minTextLength = getMinLength();
        String output = "Prefix does not exist!";

        for (int i = 0; i < minTextLength; i++) {
            for (int j = 0; j < nPrefixElements; j++) { //tu coś zle robione na kacu
                if (prefix[j].charAt(i) != prefix[nPrefixElements - 1].charAt(i)) {
                    return output;
                }
            }
            output = prefix[0].substring(0, i + 1);
        }
        return output;
    }

    private int getMinLength() {
        int n = prefix.length;
        int minLength = prefix[0].length();

        for (int i = 1; i < n; i++) {
            int nextLength = prefix[i].length();
            if (minLength > nextLength) {
                minLength = nextLength;
            }
        }

        return minLength;
    }

//    private int getMinLength() {
//        return text.stream()
//                .mapToInt(s1 -> s1.length())
//                .min()
//                .orElse(0);
//    }
}
