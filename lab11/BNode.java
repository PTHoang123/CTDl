package lab11;

public class BNode<E extends Comparable<E>>{
    private E data;
    private BNode left;
    private BNode right;
    public BNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public BNode(E data, BNode left, BNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public E getData() {
        return data;
    }
    public BNode getLeft() {
        return left;
    }
    public BNode getRight() {
        return right;
    }
    public void setData(E data) {
        this.data = data;
    }
    public void setLeft(BNode left) {
        this.left = left;
    }
    public void setRight(BNode right) {
        this.right = right;
    }
    public boolean isLeaf() {
        return left == null && right == null;
    }
    public boolean hasLeft() {
        return left != null;
    }
    public boolean hasRight() {
        return right != null;
    }
    public boolean hasBoth() {
        return left != null && right != null;
    }
    public boolean hasOnlyOne() {
        return (left != null && right == null) || (left == null && right != null);
    }
    public boolean isFull() {
        return left != null && right != null;
    }
    public boolean isHalf() {
        return (left != null && right == null) || (left == null && right != null);
    }
    public boolean isComplete() {
        return left != null && right != null;
    }
}
