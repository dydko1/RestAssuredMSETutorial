package lesson.commonprefix;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Prefix {
    List<String> text = Arrays.asList("miros", "m0ir", "mirsfsdfdsf");

    @Test
    public void test() {
        getPrefix();
    }

    private void getPrefix() {
        int n = getMinLength();
        String prefix = "";

        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < text.size(); j++) {
                if (text.get(i).charAt(i) == text.get(j).charAt(i)) {
                    System.out.println(text.get(j).lastIndexOf(i));
                }
                return;
            }
        }
    }

    private int getMinLength() {
        return text.stream()
                .mapToInt(s1 -> s1.length())
                .min()
                .orElse(0);
    }
}
