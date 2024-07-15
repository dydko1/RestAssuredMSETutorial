package trees.search;

public class BST1 {
    public BSTNode1 insert(BSTNode1 node, int data) {
        if (node == null) {
            node = new BSTNode1(data);
        } else {
            if (data <= node.getData())
                node.setLeft(insert(node.getLeft(), data));
            else
                node.setRight(insert(node.getRight(), data));
        }
        return node;
    }

    public boolean search(BSTNode1 r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    void printTree(BSTNode1 node, String prefix) {
        if (node == null)
            return;
        printTree(node.getLeft(), " " + prefix);
        System.out.print(prefix + "--" + node.getData() + " ");
        printTree(node.getRight(), prefix);
    }
}