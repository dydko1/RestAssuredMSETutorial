package com.dydko.generic.gm4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo4 {

    @Test
    public void genericDemo2() {
        List<Child> children = new ArrayList<>();

//		processParentElements(children); // compilation error

        //processElements(children);

        //Child child = children.get(0);
        //child.childSpecificMethod();

        List<Parent> parents = new ArrayList<>();
        List<Child> children2 = new ArrayList<>();
        //processElements2(parents);
        //processElements2(children2);

        List<Grandchild> grandChildren = new ArrayList<>();
//		processElements2(grandChildren); // compilation error

        //Child child2 = children.get(0);
        //child.childSpecificMethod();

    }

    private void processParentElements(List<Parent> parents) {
    }

    private void processElements(List<? extends Parent> elements) {
        Parent parent = elements.get(0);
        elements.add(null);
    }

    public static void processElements2(List<? super Child> elements) {
        Object element = elements.get(0);
//		Child parentElement = elements.get(0); // compilation error

        elements.add(new Child());
        elements.add(new Grandchild());
        elements.add(null);

//		elements.add(new Parent());
//		elements.add(new Object());
    }

}