package com.homework.Trees;

public class TreeHeight {



    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }



    static int getHeight(Node node){

        if(node == null ) {
            return 0;
        } else {
            int leftMax = 0;
            int rightMax = 0;


            leftMax = getHeight(node.left);
            rightMax = getHeight(node.right);


            if (leftMax > rightMax) {
                return leftMax + 1;
            } else {

                return rightMax + 1;
            }
        }
    }



    public static void main (String [] ags) {

    /*
    Tree
             4
            / \
           3   8
          /     \
         1       9
        / \     /
       15 16   13

     */

        Node root = new Node(4);
        Node n1 = new Node(3);
        Node n2 = new Node(8);
        Node n3 = new Node(1);
        Node n4 = new Node(9);
        Node n5 = new Node(15);
        Node n6 = new Node(16);
        Node n7 = new Node(13);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n2.right = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;


        System.out.println(getHeight(root) ) ;



        /*
    Tree
             4
            / \
           3   8
          /
         1
        / \
       15 16
      /
      10

     */

        Node rootLeft = new Node(4);
        n1 = new Node(3);
        n2 = new Node(8);
        n3 = new Node(1);

        n5 = new Node(15);
        n6 = new Node(16);
        n7 = new Node(10);

        rootLeft.left = n1;
        rootLeft.right = n2;
        n1.left = n3;
        n3.left = n5;
        n3.right = n6;
        n6.left = n7;



        System.out.println(getHeight(rootLeft) ) ;


        /*
    Tree
             4
            / \
           8   3
              /
             1
            / \
           15 16
          /
         10

     */

        Node rootRight = new Node(4);
        n1 = new Node(3);
        n2 = new Node(8);
        n3 = new Node(1);

        n5 = new Node(15);
        n6 = new Node(16);
        n7 = new Node(10);

        rootRight.right = n1;
        rootRight.left = n2;
        n1.left = n3;
        n3.left = n5;
        n3.right = n6;
        n6.left = n7;


        System.out.println(getHeight(rootRight) ) ;
    }
}
