package com.treeWork.quiz;



public class Quiz1 {

    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }

    // LCR left current right
     static void printInOrder(Node node) {
        if(node == null) return;
        if (node != null) {
            printInOrder(node.left);
            System.out.print(" " + node.value);
            printInOrder(node.right);
        }
    }

    //CLR
     static void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }


    // LRC
    static void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }


    static int serach (Node node){
        if(node == null) return Integer.MIN_VALUE;

      //  if (serach(node.left) > serach( node.right)){
          int left =  serach(node.left);
     //   }
        if(node.left== null && node.right == null)  return node.value;

        //if (serach(node.right) < serach( node.left)){
            int right = serach(node.right);
       // }
        if(left> right) return left;
        else return right;
    }

    public static void main (String [] ags){

        Node root = new Node(4);
        Node n1 = new Node (3);
        Node n2 = new Node (8);
        Node n3 = new Node (1);
        Node n4 = new Node (9);
        root.left = n1;
        root.right =n2;
        n1.left =n3;
        n2.right =n4;

        System.out.println("Inorder print .....");
        printInOrder(root);
        System.out.println();

        System.out.println("Pre order print .....");
        printPreOrder(root);
        System.out.println();

        System.out.println("Post order print .....");
        printPostOrder(root);
        System.out.println();


        System.out.println(serach( root));
    }
}
