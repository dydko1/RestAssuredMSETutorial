package trees.search;

public class BSTNode1 {
    private BSTNode1 left, right;
    private int data;

    public BSTNode1(int n) {
        left = right = null;
        this.data = n;
    }

    public BSTNode1 getLeft() {
        return left;
    }

    public void setLeft(BSTNode1 left) {
        this.left = left;
    }

    public BSTNode1 getRight() {
        return right;
    }

    public void setRight(BSTNode1 right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}