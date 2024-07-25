package lesson.compare;

public class StringCompareTo {
    public static void main(String[] args) {
        String s1 = "b";
        String s2 = "a";

        int comparison = s1.compareTo(s2);

        if (comparison < 0) {
            System.out.println(s1 + " comes before " + s2 + " lexicographically.");
        } else if (comparison > 0) {
            System.out.println(s1 + " comes after " + s2 + " lexicographically.");
        } else {
            System.out.println(s1 + " and " + s2 + " are lexicographically equal.");
        }
    }
}