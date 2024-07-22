package lesson.commonprefix;

import org.testng.annotations.Test;

public class Prefix2 {
    String[] prefixList = {"mirrosghhkjgk", "mirro", "mirrosfsdfdsf", "mirrot23", "mirr"};

    @Test
    public void displayPrefix() {
        System.out.println(getPrefix());
    }

    private String getPrefix() {
        int maxPrefixLength = getMaxPrefixLength();
        int listElements = prefixList.length;
        String prefix = "Brak elementow";

        for (int i = 0; i < maxPrefixLength; i++) {
            for (int j = 1; j < listElements; j++) {
                if (prefixList[0].charAt(i) != prefixList[j].charAt(i)) {
                    return prefix;
                }
            }
            prefix = prefixList[0].substring(0, i + 1);
        }

        return prefix;
    }

    private int getMaxPrefixLength() {
        int maxPrefixLength = prefixList[0].length();
        int n = prefixList.length;

        for (int i = 1; i < n; i++) {
            if (maxPrefixLength > prefixList[i].length()) {
                maxPrefixLength = prefixList[i].length();
            }
        }

        return maxPrefixLength;
    }
}
