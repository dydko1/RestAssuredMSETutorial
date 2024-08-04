package autoclosable1.example1;

public class Resource implements AutoCloseable {

    public void doSomething1() {
        System.out.println("Doing something with the resource!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource is being closed!");
    }
}