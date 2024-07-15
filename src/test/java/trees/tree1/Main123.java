package trees.tree1;

public class Main123 {
    public static void main(String[] args) {
        TreeDataStructure tree = new TreeDataStructure();

        tree.setRoot(new Node(270));
        tree.getRoot().setLeftChild(new Node(12));
        tree.getRoot().setRightChild(new Node(3));
        tree.getRoot().getLeftChild().setLeftChild(new Node(44));
        tree.getRoot().getLeftChild().setRightChild(new Node(17));
        tree.getRoot().getRightChild().setLeftChild(new Node(56));
        tree.getRoot().getRightChild().getLeftChild().setRightChild(new Node(100));
        tree.getRoot().getRightChild().getLeftChild().getRightChild().setRightChild(new Node(101));
        System.out.println("Inorder traversal: ");
        tree.inorder_traversal(tree.getRoot());
    }
}
