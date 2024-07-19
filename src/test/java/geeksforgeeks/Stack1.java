package geeksforgeeks;

import java.util.Iterator;
import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("Geee");
        stack.push("For");
        stack.push("fsdfdsf");

        Iterator<String> it = stack.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("---------------");
        stack.pop();
        stack.pop();
        it=stack.iterator();
        while (it.hasNext()){
            System.out.println(it.next()+" ");
        }


    }
}
