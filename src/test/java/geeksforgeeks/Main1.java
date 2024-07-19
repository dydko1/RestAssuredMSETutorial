package geeksforgeeks;

import java.util.LinkedList;

public class Main1 {
  public static void main(String[] args) {
    LinkedList<String> cars = new LinkedList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    cars.sort( (a, b) -> { return -1 * a.compareTo(b); } );
    System.out.println(cars);
  }
}