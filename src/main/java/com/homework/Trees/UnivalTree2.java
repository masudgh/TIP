package com.homework.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class UnivalTree2 {


    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }



    private static int countUnivalTree(Node node){

        int count =0;


        return count;
    }

    public static void main (String [] ags) {

    /*
    Tree
             4
            / \
           4   4
          / \    \
         4   4    4

     */

        Node root1 = new Node(4);
        Node n1 = new Node(4);
        Node n2 = new Node(4);
        Node n3 = new Node(4);
        Node n4 = new Node(4);
        Node n5 = new Node(4);

        root1.left = n1;
        root1.right = n2;
        n1.left = n3;
        n2.right = n4;
        n4.right = n5;

        System.out.println("Print original Tree 1: ");
        printLevelOrderUseOneQueandCount(root1);
        int count =countUnivalTree(root1);
        System.out.println("No of Unival Tree : ");

    }


    //Utility method - print tree
    static void printLevelOrderUseOneQueandCount(Node node) {

        if(node == null) return;

        Queue<Node> q1 = new LinkedList<>();
        q1.add(node);


        while(true){

            int levelNodeCount= q1.size();
            if(levelNodeCount==0) break;

            while(levelNodeCount>0) {


                if (q1.peek().left != null) {
                    q1.add(q1.peek().left);

                }

                if (q1.peek().right != null) {
                    q1.add(q1.peek().right);

                }

                System.out.print(q1.peek().value + " ");
                q1.remove();
                levelNodeCount--;

            }

            System.out.println();

        }


    }
}
