package trees;

public class TreeDataStructure {
    Node root = null;

    public TreeDataStructure() {
    }

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
}