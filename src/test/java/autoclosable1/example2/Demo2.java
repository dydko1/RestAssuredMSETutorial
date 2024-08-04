package autoclosable1.example2;

public class Demo2 implements AutoCloseable {
    public void show2() {
        System.out.println("Inside show2");
    }

    @Override
    public void close() throws Exception {
        System.out.println("close from demo2");
    }
}