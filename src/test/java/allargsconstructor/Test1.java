package allargsconstructor;

import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void geOuter() {
        System.out.println("------------------------");
        System.out.println(Outer.Middle1.URL);
        System.out.println(Outer.Middle1.Inner1.INNER_ELE1);
        System.out.println(Outer.Middle1.Inner2.INNER_ELE2);
        System.out.println("------------------------");
        System.out.println(Outer.Middle2.URL);
        System.out.println(Outer.Middle2.Inner1.INNER_ELE1);
        System.out.println(Outer.Middle2.Inner3.INNER_ELE3);
        System.out.println(Outer.Middle2.Inner4.INNER_ELE4);
        System.out.println("------------------------");
    }
}
