package trees.search;

import java.util.Scanner;

public class BST {
    static BSTNode root;

    public BST() {
        root = null;
    }

    private BSTNode insert(BSTNode node, int data) {
        if (node == null)
            node = new BSTNode(data);
        else {
            if (data <= node.data)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    private boolean search(BSTNode r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rval = r.data;
            if (val < rval)
                r = r.left;
            else if (val > rval)
                r = r.right;
            else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    void printTree(BSTNode node, String prefix) {
        if (node == null)
            return;
        printTree(node.left, " " + prefix);
        System.out.print(prefix + "--" + node.data + " ");
        printTree(node.right, prefix);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        root = bst.insert(root, 55);
        root = bst.insert(root, 20);
        root = bst.insert(root, 90);
        root = bst.insert(root, 80);
        root = bst.insert(root, 50);
        root = bst.insert(root, 35);
        root = bst.insert(root, 15);
        root = bst.insert(root, 65);
        System.out.print("Insertion Done");
        System.out.print("\nBST:\n");
        bst.printTree(root, "");
        int ele = 80;
        System.out.print("\nElement to be searched: " + ele);
        System.out.println("\nElement found: " + bst.search(root, 80));
    }
}