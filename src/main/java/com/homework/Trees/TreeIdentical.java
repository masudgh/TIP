package com.homework.Trees;

public class TreeIdentical {

    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }


    static boolean isIdenticalTree(Node n1, Node n2){

        if(n1 == null && n2 == null) return true;

        if(n1.value == n2.value){

            return (isIdenticalTree( n1.right, n2.right) && isIdenticalTree( n1.left, n2.left));

        }else {

            return false;
        }



    }

    public static void main (String [] ags) {

    /*
    Tree
             4                4
            / \              / \
           3   8            3   8
          /     \          /     \
         1       9        1       9


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

        root2.left = n11;
        root2.right = n21;
        n11.left = n31;
        n21.right = n41;

        System.out.println(isIdenticalTree(root1, root2));

     /*
    Tree
             4                4
            / \              / \
           3   8            3   8
          /     \          /     \
         1       9        1       10


     */




        root2 = new Node(4);

        Node n12 = new Node(3);
        Node n22 = new Node(8);
        Node n32 = new Node(1);
        Node n42 = new Node(9);
        Node n52 = new Node(10);
        root2.left = n12;
        root2.right = n22;
        n12.left = n32;
        n22.right = n52;

        System.out.println(isIdenticalTree(root1, root2));
    }
}
