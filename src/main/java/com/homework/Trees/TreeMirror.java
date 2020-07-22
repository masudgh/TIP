package com.homework.Trees;

/*
Check if two trees are Mirror
Given two Binary Trees, write a function that returns true if two trees are mirror of each other, else false.
For example, the function should return true for following input trees.

https://www.geeksforgeeks.org/check-if-two-trees-are-mirror/
 */

public class TreeMirror {


    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }


    static boolean isMirrorTree(Node n1, Node n2){

        if(n1 == null && n2 == null) return true;

        if(n1.value == n2.value){

            return (isMirrorTree( n1.right, n2.left) && isMirrorTree( n1.left, n2.right));

        }else {

            return false;
        }
    }




    public static void main (String [] ags) {

    /*
    Tree
             4                4
            / \              / \
           3   8            8   3
          /     \          /     \
         1       9        9       1


     */

        Node root1 = new Node(4);
        Node n1 = new Node(3);
        Node n2 = new Node(8);
        Node n3 = new Node(1);
        Node n4 = new Node(9);

        root1.left = n1;
        root1.right = n2;
        n1.left = n3;
        n2.right = n4;



        Node root2 = new Node(4);
        Node n11 = new Node(3);
        Node n21 = new Node(8);
        Node n31 = new Node(1);
        Node n41 = new Node(9);

        root2.left = n21;
        root2.right = n11;
        n11.right = n31;
        n21.left = n41;

        System.out.println(isMirrorTree(root1, root2));

         /*
    Tree
             4                4
            / \              / \
           3   8            8   3
          /     \          /     \
         1       9        1       9


     */


        Node n32 = new Node(1);
        Node n42 = new Node(9);

        root2.left = n2;
        root2.right = n1;
        n1.right = n42;
        n2.left = n32;

        System.out.println(isMirrorTree(root1, root2));
    }
}
