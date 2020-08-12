package com.homework.Trees;

/*
Given a binary tree, find the largest Binary Search Tree (BST), where largest means BST with
largest number of nodes in it. The largest BST must include all of its descendants.


 */
public class LargestBST {

    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }

    static int findLargestBST2(Node node) {
        if (node == null) return 0;
        int countLeft = 0;
        int countRight = 0;

        if(isBST(node)) {
           // if(node.left!=null && node.right!=null)
          //     return 3;
          //  else if (node.left!=null || node.right!=null)
                return 2;
          //  else
          //      return 1;
        }else {

            countLeft = findLargestBST2(node.left);
            countRight = findLargestBST2(node.right);
            return Math.max(countLeft, countRight);
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

    static int findLargestBST1(Node node) {
        if (node == null) return 0;
        int countLeft = 0;
        int countRight = 0;
        if (node.left != null && node.right != null)//{
            if (node.value > node.left.value && node.value < node.right.value) {
                return 2;
            }
            /*else {
                countLeft += findLargestBST1(node.left);
                countRight += findLargestBST1(node.right);
            }
        }  else if (node.left == null && node.right == null){
            return 1;
        }else{
            countLeft += findLargestBST1(node.left);
            countRight += findLargestBST1(node.right);
        }*/

        countLeft += findLargestBST1(node.left);
        countRight += findLargestBST1(node.right);
        return Math.max(countLeft, countRight);
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
        int count1 = findLargestBST2(root);
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
        Node n28 = new Node(146);

        root2.left = n21;
        root2.right = n22;
        n21.left = n23;
        n21.right = n24;
        n22.left = n25;
        n22.right = n26;
        n26.left = n27;
        n26.right = n28;

        System.out.println("Max BST ...");
        int count2 = findLargestBST2(root2);
        System.out.println(count2);

    }
}
