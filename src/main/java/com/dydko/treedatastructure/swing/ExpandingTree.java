package com.dydko.treedatastructure.swing;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.DefaultMutableTreeNode;


import java.awt.*;
import java.awt.event.*;

class ExpandingTree implements TreeExpansionListener {

    ExpandingTree() {

        JFrame frame = new JFrame();

        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Collection");
        DefaultMutableTreeNode set = new DefaultMutableTreeNode("Set");
        DefaultMutableTreeNode list = new DefaultMutableTreeNode("List");
        DefaultMutableTreeNode list2 = new DefaultMutableTreeNode("List2");
        DefaultMutableTreeNode queue = new DefaultMutableTreeNode("Queue");
        DefaultMutableTreeNode arraylist = new DefaultMutableTreeNode("ArrayList");
        DefaultMutableTreeNode linkedlist = new DefaultMutableTreeNode("Linked List");
        DefaultMutableTreeNode linkedlist2 = new DefaultMutableTreeNode("Linked List A");
        DefaultMutableTreeNode linkedlist3 = new DefaultMutableTreeNode("Linked List B");
        DefaultMutableTreeNode linkedlist4 = new DefaultMutableTreeNode("Linked List C");

        top.add(set);
        top.add(list);
        top.add(queue);
        top.add(list2);

        list.add(arraylist);
        list.add(linkedlist);

        list2.add(linkedlist2);
        linkedlist2.add(linkedlist3);
        linkedlist3.add(linkedlist4);
        linkedlist3.add(linkedlist4);
        linkedlist3.add(arraylist);
        linkedlist3.add(arraylist);
        linkedlist3.add( new DefaultMutableTreeNode("Linked List"));

        JTree tree = new JTree(top);
        tree.addTreeExpansionListener(this);

        frame.add(tree);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String args[]) {

        new ExpandingTree();
    }

    public void treeCollapsed(TreeExpansionEvent e) {
        System.out.println("You collapsed the tree.");
    }

    public void treeExpanded(TreeExpansionEvent e) {
        System.out.println("Path of the expanded tree: " + e.getPath());
    }
}