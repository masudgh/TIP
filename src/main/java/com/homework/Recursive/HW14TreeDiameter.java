package com.homework.Recursive;

import com.homework.Trees.TreeTraversal;

/*

The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes.
 This may or may not pass through the root node

https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/


 */
public class HW14TreeDiameter {

    static int maxDiameter =0;   //Remove global variable

    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }


    static int calcDiameterOfTree(Node node){
        maxDiameter =0;
        calcDiameterOfTreeHelpder(node);
        return maxDiameter;
    }

    static int calcDiameterOfTreeHelpder(Node node) {
        int nodeLeft, nodeRight;
        if (node != null) {

            nodeLeft =  calcDiameterOfTreeHelpder(node.left);
            nodeRight = calcDiameterOfTreeHelpder(node.right);
            if (nodeLeft + nodeRight +1 > maxDiameter) maxDiameter = nodeLeft + nodeRight +1;

        }else{
            return 0;
        }

        return 1 + Math.max(nodeLeft, nodeRight);
    }

    // 1)
    // LCR left current right
    static void printInOrder2(Node node) {
        if (node != null) {
            printInOrder2(node.left);
            System.out.print(" " + node.value);
            printInOrder2(node.right);
        }
    }



    // 1)
    // LCR left current right
    static void printInOrder(Node node, Node nextNode) {
        if (node != null) {
            printInOrder(node.left,nextNode);
            if(node.value == nextNode.value) System.out.print(" " + node.value);
            printInOrder(node.right,nextNode);
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
        System.out.print(" THe maximum diameter is : ");
        System.out.println(calcDiameterOfTree(root) ) ;

        printInOrder(root,n1);
        System.out.println();
        printInOrder2(root);
        System.out.println();
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

        System.out.print(" THe maximum diameter is : ");
        System.out.println(calcDiameterOfTree(rootLeft) ) ;


         /*
    Tree
             4
              \
               3
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
        n1.left = n3;
        n3.left = n5;
        n3.right = n6;
        n6.left = n7;

        System.out.print(" THe maximum diameter is : ");
        System.out.println(calcDiameterOfTree(rootRight) ) ;
    }
}
