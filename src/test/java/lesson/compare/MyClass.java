package lesson.compare;

public class MyClass implements Comparable<MyClass> {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(MyClass o) {
        // Compare the current object (this) with the specified object (other)
        if (this.value < o.value) {
            return -1;
        } else if (this.value > o.value) {
            return 1;
        } else {
            return 0;
        }
    }

    // Getter and Setter for value
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // toString method to display the object
    @Override
    public String toString() {
        return "Miro, MyClass{" +
                "value=" + value +
                '}';
    }
}