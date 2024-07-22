package lesson.twosortedlists;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MargeTwoLists {
    List<Integer> list1 = Arrays.asList(1, 23, 4, 5, 6, 7, 8, 90, 2);
    List<Integer> list2 = Arrays.asList(34, 5, 6, 7, 8, 99, 555);

    @Test
    public void sortList() {
        List<Integer> list3 = new ArrayList<>();
        list3.addAll(list1);
        list3.addAll(list2);
//        Collections.sort(list3);
//        System.out.println(list3);

        list3.sort((i1, i2) -> -1 * i1.compareTo(i2));
        System.out.println(list3);
    }
}
