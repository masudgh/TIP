package com.treeWork.ds;

public class Node {


    public Node left, right;
    public int value;

    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
    public Node( int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }
}
