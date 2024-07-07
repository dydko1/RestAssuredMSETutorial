package geeksforgeeks;

import java.util.List;

public class ListOfList {

    public <K> void iterateUsingForEach(List<List<K>> listOfList) {
        System.out.println("[-------------------");
        for (List<K> list : listOfList) {
            System.out.print(" [");
            for (K ele : list) {
                System.out.print(" " + ele + ", ");
            }
            System.out.println("],");
        }
        System.out.println("-------------------]");
    }
}