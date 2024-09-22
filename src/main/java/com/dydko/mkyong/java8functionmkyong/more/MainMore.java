package com.dydko.mkyong.java8functionmkyong.more;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class MainMore {
    public static void main(String[] args) {

        MainMore mainMore = new MainMore();
        List<String> list = Arrays.asList("node", "c++", "java", "javascript");
        List<String> result = mainMore.filterList(list, 3, mainMore::filterByLength);
        System.out.println(result);

        List<String> result1 = mainMore.filterList(list, 3, (l1, size) -> {
            if (l1.length() > size) {
                return l1;
            } else {
                return null;
            }
        });
        System.out.println(result1);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result3 = mainMore.filterList(numbers, 2, (l1, con) -> {
            if (l1 % con == 0)
                return l1;
            else {
                return null;
            }
        });
        System.out.println(result3);
    }

    public String filterByLength(String str, Integer size) {
        if (str.length() > size)
            return str;
        else
            return null;
    }

    public <T, U, R> List<R> filterList(List<T> list1, U cond,
                                        BiFunction<T, U, R> func) {
        List<R> result = new ArrayList<>();
        for (T t : list1) {
            R apply = func.apply(t, cond);
            if (apply != null)
                result.add(apply);
        }
        return result;
    }
}