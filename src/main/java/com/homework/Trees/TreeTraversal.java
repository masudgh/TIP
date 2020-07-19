package com.homework.Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a root node of a Binary Tree perform the following operations.
1. Print Tree values in In-order
2. Print Tree values in Pre-order
3. Print Tree values in Post-order
4. Print Level order on same line (use BFS, single queue method)
5. Print Level order on separate line; each level on separate line (use BFS, two queues method)
6. Print Level order on separate line; each level on separate line (use BFS, single queue using count)
Note: There are other ways also for level traversal like using a sentinal node etc. if you want to try that.
 */
public class TreeTraversal {
    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }



    // 1)
    // LCR left current right
    static void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(" " + node.value);
            printInOrder(node.right);
        }
    }

    // 2)
    //CLR - current left right
    static void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    //3)
    // LRC -- left right current
    static void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    // 4) Level order
    static void printLevelOrder1(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);


        while(!queue.isEmpty()){
            Node tmpNode = queue.remove();
            System.out.print(" " + tmpNode.value);

            if (tmpNode.left != null) {
                queue.add(tmpNode.left);
            }

            if (tmpNode.right != null) {
                queue.add(tmpNode.right);
            }
        }
    }


    // 4) Level order -use BFS, two queues method
    static void printLevelOrder2(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Queue<Node> queuePosition = new LinkedList<>();
        queuePosition.add(node);

        while(!queue.isEmpty()){
            Node tmpNode = queue.remove();
            System.out.print(" " + tmpNode.value);

            if (tmpNode.left != null) {
                queue.add(tmpNode.left);
            }

            if (tmpNode.right != null) {
                queue.add(tmpNode.right);
            }
        }
    }

    // 6) Level order --(use BFS, single queue using count)
    static void printLevelOrder3(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        // 2^0 + 2^1 + …. 2^h = 2^(h+1)-1.
        int count =0;
        int level = 0;
        double levelAgg =0;
        while(!queue.isEmpty()){

            Node tmpNode;
            tmpNode = queue.remove();
            System.out.print(" " + tmpNode.value);
           // count++;


            if( Math.pow(2,level)+levelAgg == count){
                levelAgg +=  Math.pow(2,level);
                System.out.println();
                level ++;
            }




            if (tmpNode.left != null) {
                queue.add(tmpNode.left);
                count++;
            }else {
                count+=2;
            }


            if (tmpNode.right != null) {
                queue.add(tmpNode.right);
                count++;
            }else{
                count+=2;
            }

        }

    }

    public static void main (String [] ags){

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
        Node n1 = new Node (3);
        Node n2 = new Node (8);
        Node n3 = new Node (1);
        Node n4 = new Node (9);
        Node n5 = new Node (15);
        Node n6 = new Node (16);
        Node n7 = new Node (13);
        root.left = n1;
        root.right =n2;
        n1.left =n3;
        n2.right =n4;
        n3.left = n5;
        n3.right =n6;
        n6.left = n7;

        System.out.println("Inorder print .....");
        printInOrder(root);
        System.out.println();

        System.out.println("Pre order print .....");
        printPreOrder(root);
        System.out.println();

        System.out.println("Post order print .....");
        printPostOrder(root);
        System.out.println();

        System.out.println("Level order print .....");
        printLevelOrder1(root);

        System.out.println();
        System.out.println("Level order print .....");
        printLevelOrder3(root);
    }
}
