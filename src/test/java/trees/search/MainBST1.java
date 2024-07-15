package trees.search;

public class MainBST1 {

    static BSTNode1 root;

    public static void main(String[] args) {

        BST1 bst = new BST1();
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
