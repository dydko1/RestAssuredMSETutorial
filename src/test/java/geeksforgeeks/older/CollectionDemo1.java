package geeksforgeeks.older;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class CollectionDemo1 {
    public static void main(String[] args) {

        int arr[] = new int[]{1, 2, 3, 4};
        Vector<Integer> v = new Vector<>();
        Hashtable<Integer, String> h = new Hashtable<>();

        v.addElement(1);
        v.addElement(2);

        h.put(1, "geek");
        h.put(2, "4geeks");

        System.out.println(arr[0]);
        System.out.println(v.elementAt(0));
        System.out.println(h.get(2));
    }
}