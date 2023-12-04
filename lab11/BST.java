package lab11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
    private BNode<E> root;
    public BST() {
        this.root = null;
    }
    public BST(BNode<E> root) {
        this.root = root;
    }
    public BNode<E> getRoot() {
        return root;
    }
    public void setRoot(BNode<E> root) {
        this.root = root;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public boolean isLeaf() {
        return root.isLeaf();
    }
    public boolean hasLeft() {
        return root.hasLeft();
    }
    public boolean hasRight() {
        return root.hasRight();
    }

    public void add(E data) {
        root = add(root, data);
    }
    private BNode<E> add(BNode<E> root, E data) {
        if (root == null) {
            return new BNode<>(data);
        }
        if (data.compareTo(root.getData()) < 0) {
            root.setLeft(add(root.getLeft(), data));
        }
        else if (data.compareTo(root.getData()) > 0) {
            root.setRight(add(root.getRight(), data));
        }
        return root;
    }
    public void add(Collection<E> col) {
        for(E e : col) {
            add(e);
        }
    }
    public int depth(E node){
        return depth(root, node);
    }
    private int depth(BNode<E> root, E node) {
        if (root == null) {
            return -1;
        }
        if (root.getData().equals(node)) {
            return 0;
        }
        int left = depth(root.getLeft(), node);
        int right = depth(root.getRight(), node);
        if (left == -1 && right == -1) {
            return -1;
        }
        if (left == -1) {
            return right + 1;
        }
        if (right == -1) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }
    public int height() {
        return height(root);
    }
    private int height(BNode<E> root) {
        if (root == null) {
            return -1;
        }
        int left = height(root.getLeft());
        int right = height(root.getRight());
        return Math.max(left, right) + 1;
    }
    public int size(){
        return size(root);
    }
    private int size(BNode<E> root) {
        if (root == null) {
            return 0;
        }
        return size(root.getLeft()) + size(root.getRight()) + 1;
    }
    public boolean contains(E data) {
        return contains(root, data);
    }
    private boolean contains(BNode<E> root, E data) {
        if (root == null) {
            return false;
        }
        if (root.getData().equals(data)) {
            return true;
        }
        return contains(root.getLeft(), data) || contains(root.getRight(), data);
    }
    public E findMin(){
        return findMin(root);
    }
    private E findMin(BNode<E> root) {
        if (root == null) {
            return null;
        }
        if (root.getLeft() == null) {
            return root.getData();
        }
        return (E) findMin(root.getLeft());
    }
    public E findMax(){
        return findMax(root);
    }
    private E findMax(BNode<E> root){
        if(root == null){
            return null;
        }
        if(root.getRight() == null){
            return root.getData();
        }
        return (E) findMax(root.getRight());
    }
    public boolean remove(E data){
        return remove(root, data);
    }
    private boolean remove(BNode<E> root, E data){
        if(root == null){
            return false;
        }
        if(root.getData().equals(data)){
            if(root.isLeaf()){
                root = null;
            }
            else if(root.hasOnlyOne()){
                if(root.hasLeft()){
                    root = root.getLeft();
                }
                else{
                    root = root.getRight();
                }
            }
            else{
                E min = (E) findMin(root.getRight());
                root.setData(min);
                remove(root.getRight(), min);
            }
            return true;
        }
        return remove(root.getLeft(), data) || remove(root.getRight(), data);
    }
    // get the descendants of a node
    public List<E> descendants(E data) {
        List<E> list = new ArrayList<>();
        descendants(root, data, list);
        return list;
    }
    private void descendants(BNode<E> root, E data, List<E> list) {
        if (root == null) {
            return;
        }
        if (root.getData().equals(data)) {
            if (root.hasLeft()) {
                list.add((E) root.getLeft().getData());
            }
            if (root.hasRight()) {
                list.add((E) root.getRight().getData());
            }
            return;
        }
        descendants(root.getLeft(), data, list);
        descendants(root.getRight(), data, list);
    }

    public List<E> ancestors(E data) {
        List<E> list = new ArrayList<>();
        ancestors(root, data, list);
        return list;
    }
    private void ancestors(BNode<E> root, E data, List<E> list) {
        if (root == null) {
            return;
        }
        if (root.getData().equals(data)) {
            return;
        }
        if (root.hasLeft() && root.getLeft().getData().equals(data)) {
            list.add(root.getData());
            return;
        }
        if (root.hasRight() && root.getRight().getData().equals(data)) {
            list.add(root.getData());
            return;
        }
        ancestors(root.getLeft(), data, list);
        ancestors(root.getRight(), data, list);
    }
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(BNode<E> root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrder(root.getRight());
    }
    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(BNode<E> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(BNode<E> root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData() + " ");
    }
}