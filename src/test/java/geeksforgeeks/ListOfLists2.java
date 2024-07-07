package geeksforgeeks;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListOfLists2 {

    public static <K> void iterateUsingIterators(List<List<K>> listOfLists) {

        Iterator listOfIterator = listOfLists.iterator();

        System.out.println("[---");
        while (listOfIterator.hasNext()) {
            List<K> list = new LinkedList<>();
            list = (List<K>) listOfIterator.next();

            System.out.print("  [");
            Iterator eachListIterator = list.iterator();
            while (eachListIterator.hasNext()) {
                System.out.print(
                        "  "
                                + eachListIterator.next()
                                + ", ");
            }
            System.out.println("], ");
        }
        System.out.println("---]");
    }
}
