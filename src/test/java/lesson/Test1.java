package lesson;

import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

    static String x = "napissssssooooooooos";

    @Test
    public void ddd() {

        Stream<Character> charStream = x.chars()
                .mapToObj(c -> (char) c);
        charStream.forEach(System.out::println);

//        char[] charStream1 = x.toCharArray();
//        Stream<Character> xxxx=charStream1

        List<Character> charList = x.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        System.out.println("dddddddddddd" + charList);
    }
}