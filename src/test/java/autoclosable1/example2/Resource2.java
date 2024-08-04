package autoclosable1.example2;

public class Resource2 {
    public static void main(String[] args) {
        try (Demo1 demo1 = new Demo1();
             Demo2 demo2 = new Demo2()) {
            int x = 10 / 0;
            demo1.show1();
            demo2.show2();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
