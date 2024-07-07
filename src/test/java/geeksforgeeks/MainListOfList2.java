package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

import static geeksforgeeks.ListOfLists2.iterateUsingIterators;

public class MainListOfList2 {
    public static void main(String[] args) {
        // List of Lists
        ArrayList<List<String>> listOfLists = new ArrayList();

        // Create N lists one by one
        // and append to the list of lists
        List<String> list1
                = new ArrayList();
        list1.add("A");
        list1.add("B");
        listOfLists.add(list1);

        List<String> list2
                = new ArrayList();
        list2.add("CVCCCC");
        listOfLists.add(list2);

        List<String> list3
                = new ArrayList();
        list3.add("XXXX");
        list3.add("YYYY");
        list3.add("ZZZZ");
        listOfLists.add(list3);

        // Iterate the 2D list
        iterateUsingIterators(listOfLists);
    }
}