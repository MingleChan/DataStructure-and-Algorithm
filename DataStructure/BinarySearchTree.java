package cn.superming.DataStructure;

public class BinarySearchTree {
    class Node {
        int key;
        int value;
        Node left, right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(int key, int value){
        root = insert(root, key, value);
    }

    public boolean contain(int key) {
        return contain(root, key);
    }

    public int search(int key){
        return search(root, key);
    }

    public void preOrder(){
        preOrder(root);
    }

    public void inOrder(){
        inOrder(root);
    }

    public void postOrder(){
        postOrder(root);
    }

    private Node insert(Node node, int key, int value) {
        if (node == null){
            size++;
            return new Node(key, value);
        }

        if (key == node.key)
            node.value = value;
        else if (key < node.key){
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    private boolean contain(Node node, int key){
        if (node == null) return false;
        if (key == node.key) return true;
        else if (key < node.key) return contain(node.left, key);
        else return contain(node.right, key);
    }

    private Integer search(Node node, int key){
        if (node == null) return null;
        if (key == node.key) return node.value;
        else if (key < node.key) return search(node.left, key);
        else return search(node.right, key);
    }

    private void preOrder(Node node){
        if (node == null)
            return;
        System.out.println(node.key + " : " + node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.key + " : " + node.value);
        inOrder(node.right);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key + " : " + node.value);
    }
}
