package trees;

public class TreeDataStructure {
    Node root = null;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    void inorder_traversal(Node node) {
        if (node != null) {
            inorder_traversal(node.getLeftChild());
            System.out.print(node.getData() + ", ");
            inorder_traversal(node.getRightChild());
        }
    }

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