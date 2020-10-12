package com.homework.Trees;


/*
Given a binary tree, find the largest Binary Search Tree (BST), where largest means BST with
largest number of nodes in it. The largest BST must include all of its descendants.


 */
public class LargestBSTBack {

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


    static boolean isBST(Node node){
        if(node == null) return false;

        if(node.left !=null && node.right !=null) {
            if(isRightBranchBST(node.right, node) && isLeftBranchBST(node.left, node))
                return isBST(node.left) && isBST(node.right);
            else
                return false;
        }else if (node.left !=null){
            return isBST(node.left);
        }else if (node.right !=null) {
            return isBST(node.right);
        }

        return true;
    }


    static boolean isRightBranchBST(Node node , Node parent){

        if (parent.value < node.value){
            if(node.left ==null && node.right ==null) return true;
            if (node.left !=null) return isRightBranchBST(node.left, parent);
            else
                return isRightBranchBST(node.right, parent);

        }
        return false;
    }

    static boolean isLeftBranchBST(Node node , Node parent){

        if (parent.value > node.value){
            if(node.left ==null && node.right ==null) return true;
            if (node.left !=null) return isLeftBranchBST(node.left, parent);
            else
                return isLeftBranchBST(node.right, parent);

        }
        return false;
    }


    public static  int getNodeCount(Node node)
    {
        int count =1;
        if (node == null)
            return 0;
        else {
            count += getNodeCount(node.left);
            count+=  getNodeCount(node.right);
            return count;
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






    private static int findSizeOfLargestBST(Node currentNode, int[] min, int[] max, boolean[] isBST, int[] maxBSTSize)
    {
        min[0] = Integer.MAX_VALUE;
        max[0] = Integer.MIN_VALUE;

        if (currentNode == null)
        {
            isBST[0] = true;
            return 0;
        }

        if(currentNode.value == 13) {
            System.out.println(currentNode.value);
        }

        // in this call, min[0] and max[0] would be updated
        // isBST[0] would be updated if left sub-tree is BST
        int leftTreeSize = findSizeOfLargestBST(currentNode.left, min, max, isBST, maxBSTSize);

        // check if left sub-tree is a BST and no node in left sub-tree is greater than current node
        boolean isLeftValid = isBST[0] && (max[0] < currentNode.value);

        // before updating min[0] and max[0] in right sub-tree save min and max values seen so far
        int tempMin = minimum(currentNode.value, min[0]);
        int tempMax = maximum(currentNode.value, max[0]);

        // in this call, min[0] and max[0] would be updated
        // isBST[0] would be updated if right sub-tree is BST
        int rightTreeSize = findSizeOfLargestBST(currentNode.right, min, max, isBST, maxBSTSize);

        // check if right sub-tree is a BST and no node in right sub-tree is less than current node
        boolean isRightValid = isBST[0] && (currentNode.value < min[0]);

        // before returning update min[0] which would be the minimum value seen in this sub-tree with root as currentNode
        // and update max[0] which would be the maximum value seen in this sub-tree before
        min[0] = minimum(tempMin, min[0]);
        max[0] = maximum(tempMax, max[0]);

        // if this tree with root as currentNode is a valid BST
        if (isLeftValid && isRightValid)
        {
            // this sub-tree at currentNode is also a BST
            isBST[0] = true;

            // update max BST size accordingly
            if ((1 + leftTreeSize + rightTreeSize) > maxBSTSize[0])
            {
                maxBSTSize[0] = (1 + leftTreeSize + rightTreeSize);
            }

            return (1 + leftTreeSize + rightTreeSize);
        }

        // if this tree is not BST, we don't really use the value returned by it. Return -1.
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

    public static void findLargestBST(Node root, int[] maxBSTSize)
    {
        int[] min = new int[1];
        int[] max = new int[1];

        boolean[] isBST = new boolean[1];

        findSizeOfLargestBST(root, min, max, isBST, maxBSTSize);
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


       // System.out.println("Max BST ...");
       // int count1 = findLargestBSTEff(root);
       // System.out.println(count1);



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

        int[] maxBSTSize = new int[1];
        System.out.println("Max BST ...");
        //findLargestBST(root2, maxBSTSize);
        //System.out.println(maxBSTSize[0]);


        //System.out.println("Max BST ...");
        int count2 = findLargestBSTEff(root2);
        System.out.println(count2);

    }
}
