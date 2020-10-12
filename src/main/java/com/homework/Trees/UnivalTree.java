package com.homework.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class UnivalTree {


    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }

    static class IsUnival {

        boolean isUnival ;
        int count;

        public IsUnival(boolean isUnival, int count) {
            this.isUnival = isUnival;
            this.count = count;
        }
    }



    private static int countUnivalTree(Node node){

        return helperCountUnivalTree(node).count;

    }

    private static IsUnival helperCountUnivalTree(Node node){
        if (node == null ) {
            return new IsUnival(true,0);
        }

        IsUnival leftTreeCount = helperCountUnivalTree(node.left);
        IsUnival rightTreeCount = helperCountUnivalTree(node.right);
        int total = leftTreeCount.count + rightTreeCount.count;

        if(leftTreeCount.isUnival && rightTreeCount.isUnival){
            if(node.left !=null && node.value != node.left.value){
                return new IsUnival( false, total);
            }
            if(node.right !=null && node.value != node.right.value){
                return  new IsUnival( false,total);
            }
            return new IsUnival( true, total+1);
        }

        return new IsUnival( false, total);
    }

    public static void main (String [] ags) {

    /*
    Tree
             4
            / \
           4   4
          / \    \
         4   4    5

     */

        Node root1 = new Node(4);
        Node n1 = new Node(4);
        Node n2 = new Node(4);
        Node n3 = new Node(4);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        root1.left = n1;
        root1.right = n2;
        n1.left = n3;
        n2.right = n4;
        n4.right = n5;

        System.out.println("Print original Tree 1: ");
        printLevelOrderUseOneQueandCount(root1);
        int count =countUnivalTree(root1);
        System.out.println("No of Unival Tree : " + count);

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
