package com.dydko.treedatastructure.works;

public class Main1 {
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(6);


        System.out.println(
                "Level order traversal of binary tree is ");
        tree.printLevelOrder();
    }
}