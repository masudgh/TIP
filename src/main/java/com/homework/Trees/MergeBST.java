package com.homework.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MergeBST {

    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }


    // 5) Level order --(use BFS, single queue using count)
    static void merge(Node node1, Node node2) {

        if(node1 == null) return;
        if(node2 == null) return;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(node1);
        q2.add(node2);


        while(true){

            int levelNodeCount1= q1.size();
            int levelNodeCount2= q2.size();
            if(levelNodeCount1==0 && levelNodeCount2==0) break;

            while(levelNodeCount1>0 || levelNodeCount2>0 ) {


                if (levelNodeCount1>0 && q1.peek().left != null) {
                    q1.add(q1.peek().left);

                }

                if (levelNodeCount2>0 && q2.peek().left != null) {
                    q1.add(q2.peek().left);

                }


                if (levelNodeCount1>0 && q1.peek().right != null) {
                    q1.add(q1.peek().right);

                }

                if (levelNodeCount2>0 && q2.peek().right != null) {
                    q1.add(q2.peek().right);

                }

                if(q1.peek().value> q2.peek().value) {
                    System.out.print(q2.peek().value + " ");
                    q2.remove();
                    levelNodeCount2--;
                }else {
                    System.out.print(q1.peek().value + " ");
                    q1.remove();
                    levelNodeCount1--;
                }

            }

            System.out.println();

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

       // System.out.println("Print original Tree 1: ");
       // printLevelOrderUseOneQueandCount(root1);




        /*
    Tree
             5
            / \
           2   10
          /     \
         0       12

     */

        Node root2 = new Node(5);
        Node n10 = new Node(2);
        Node n11 = new Node(10);
        Node n21 = new Node(12);
        Node n20 = new Node(0);



        root2.right = n11;
        root2.left = n10;
        n11.right = n21;
        n10.left = n20;


      //  System.out.println("Print original Tree 2: ");
      //  printLevelOrderUseOneQueandCount(root2);
        merge(root1, root2);


    }


    // 5) Level order --(use BFS, single queue using count)
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
