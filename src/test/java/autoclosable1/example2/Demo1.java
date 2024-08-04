package autoclosable1.example2;

public class Demo1 implements AutoCloseable {
    public void show1() {
        System.out.println("Inside show1");
    }

    @Override
    public void close() throws Exception {
        System.out.println("close from demo1");
    }


}