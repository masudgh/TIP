package com.homework.Trees;



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


        root2.left = n2;
        root2.right = n1;
        n1.right = n3;
        n2.left = n4;

        System.out.println(isMirrorTree(root1, root2));

         /*
    Tree
             4                4
            / \              / \
           3   8            8   3
          /     \          /     \
         1       9        1       9


     */

        root2.left = n1;
        root2.right = n2;
        n1.left = n3;
        n2.right = n4;


        root2.left = n2;
        root2.right = n1;
        n1.right = n4;
        n2.left = n3;

        System.out.println(isMirrorTree(root1, root2));
    }
}
