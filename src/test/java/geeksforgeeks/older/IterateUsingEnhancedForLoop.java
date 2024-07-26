package geeksforgeeks.older;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterateUsingEnhancedForLoop {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Mirro");
        list.add("dd");
        list.add("dddddd");

        for (String ele : list) {
            System.out.println(ele);
        }

        list.forEach(s -> System.out.println(s));

        Iterator<String> ite = list.iterator();
        while ((ite.hasNext())) {
            String ele1 = ite.next();
            System.out.println(ele1);
        }
    }
}
