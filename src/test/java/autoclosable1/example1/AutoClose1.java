package autoclosable1.example1;

public class AutoClose1 {
    public static void main(String[] args) {
        try (Resource resource = new Resource()) {
            resource.doSomething1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
