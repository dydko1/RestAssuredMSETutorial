package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class MainListOfList {
    public static void main(String[] args) {

        ListOfList listOfList =new ListOfList();
        // List of Lists
        ArrayList<List<Integer>> listOfLists
                = new ArrayList<List<Integer>>();

        // Create N lists one by one
        // and append to the list of lists
        List<Integer> list1
                = new ArrayList<Integer>();
        list1.add(5);
        list1.add(10);
        listOfLists.add(list1);

        List<Integer> list2
                = new ArrayList<Integer>();
        list2.add(1);
        listOfLists.add(list2);

        List<Integer> list3
                = new ArrayList<Integer>();
        list3.add(20);
        list3.add(30);
        list3.add(40);
        listOfLists.add(list3);

        // Iterate the 2D list
        listOfList.iterateUsingForEach(listOfLists);
    }
}
