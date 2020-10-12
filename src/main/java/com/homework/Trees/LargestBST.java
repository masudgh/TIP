package com.homework.Trees;


/*
Given a binary tree, find the largest Binary Search Tree (BST), where largest means BST with
largest number of nodes in it. The largest BST must include all of its descendants.


 */
public class LargestBST {

    static class Node {
        Node left, right;
        int value;
        Node(){}
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }


    static Node minNode = new Node();
    static Node maxNode = new Node();

    static int findLargestBSTEff(Node node) {
        minNode.value = Integer.MAX_VALUE;
        maxNode.value = Integer.MIN_VALUE;
        boolean [] isBST =new boolean[1]; //Store if the tree is BST from this node to leaf
        int[] maxBSTSize = new int[1]; // Store max BST size along the search
        findLargestBST(node,isBST,maxBSTSize );
        return maxBSTSize[0];
    }

    static int findLargestBST(Node node, boolean[] isBST, int [] maxBSTSize) {

        if (node == null) {
            minNode.value = Integer.MAX_VALUE;
            maxNode.value = Integer.MIN_VALUE;
            isBST[0] = true;
            return 0;
        }

        int leftCount=0;
        int rightCount=0;

        boolean leftValid = false;
        boolean rightValid = false;

        leftCount =  findLargestBST(node.left, isBST, maxBSTSize);
        leftValid =  maxNode.value < node.value && isBST[0];

        int tempMin = minimum(node.value, minNode.value);
        int tempMax = maximum(node.value, maxNode.value);

        rightCount =  findLargestBST(node.right, isBST, maxBSTSize);
        rightValid =  minNode.value > node.value && isBST[0];

        minNode.value = minimum(tempMin, minNode.value);
        maxNode.value = maximum(tempMax, maxNode.value);


        if (leftValid && rightValid){
            isBST[0] = true;
            if((1 + leftCount + rightCount) >maxBSTSize[0]) {
                maxBSTSize[0] = 1 + leftCount + rightCount;
            }
            return 1 + leftCount + rightCount;
        }

        isBST[0] = false;
        return -1;
    }

    private static int minimum(int a, int b)
    {
        if (a < b) return a;
        return b;
    }

    private static int maximum(int a, int b)
    {
        if (a > b) return a;
        return b;
    }


    public static void main (String [] ags) {
    
    /*
    Tree
              10
            /   \
          15     1
          / \   / \
         7  16  9  14


     */

        Node root = new Node(10);
        Node n1 = new Node(15);
        Node n2 = new Node(1);
        Node n3 = new Node(7);
        Node n4 = new Node(16);
        Node n5 = new Node(9);
        Node n6 = new Node(14);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;


        System.out.println("Max BST ...");
        int count1 = findLargestBSTEff(root);
        System.out.println(count1);

        /*
    Tree
              10
            /   \
           6     12
          / \   / \
         7   4  9  14
                   / \
                  13  16
     */

        Node root2 = new Node(10);
        Node n21 = new Node(6);
        Node n22 = new Node(12);
        Node n23 = new Node(7);
        Node n24 = new Node(4);
        Node n25 = new Node(9);
        Node n26 = new Node(14);
        Node n27 = new Node(13);
        Node n28 = new Node(16);

        root2.left = n21;
        root2.right = n22;
        n21.left = n23;
        n21.right = n24;
        n22.left = n25;
        n22.right = n26;
        n26.left = n27;
        n26.right = n28;

        System.out.println("Max BST ...");
        int count2 = findLargestBSTEff(root2);
        System.out.println(count2);

    }
}
