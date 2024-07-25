package lesson.compare;

public class MyClassMain {

    public static void main(String[] args) {
        MyClass obj1 = new MyClass(10);
        MyClass obj2 = new MyClass(20);

        System.out.println(obj1.compareTo(obj2));
        System.out.println(obj2.compareTo(obj1));
        System.out.println(obj1.compareTo(obj1));
        System.out.println(obj1.toString());
    }
}