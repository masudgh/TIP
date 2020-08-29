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
    static void printInOrder2(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(" " + node.value);
            printInOrder(node.right);
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
    static void printLevelOrderTwoQueue(Node node) {

        if(node == null) return;

        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();

        queue1.add(node);


        while( !queue1.isEmpty() || !queue2.isEmpty() ){



            while(!queue1.isEmpty()){
                if(queue1.peek().left !=null){
                    queue2.add(queue1.peek().left);
                }

                if(queue1.peek().right !=null){
                    queue2.add(queue1.peek().right);
                }
                System.out.print(queue1.peek().value+" ");
                queue1.remove();

            }

            System.out.println();

            while(!queue2.isEmpty()){

                if(queue2.peek().left !=null){
                    queue1.add(queue2.peek().left);
                }

                if(queue2.peek().right !=null){
                    queue1.add(queue2.peek().right);
                }
                System.out.print(queue2.peek().value+ " ");
                queue2.remove();

            }

            System.out.println();
        }


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

    static void levelOrderPrintHelper(Node node, int level){

        if(node == null) return ;

        if(level ==1) {
            System.out.print(" " + node.value);
        } else if(level >1){
            levelOrderPrintHelper(node.left, level-1);
            levelOrderPrintHelper(node.right, level-1);
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
        n4.left = n7;

        System.out.println("Inorder print .....");
        printInOrder(root);
        System.out.println();
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
        System.out.println("Level order print line by line: use one queue and count.....");
        printLevelOrderTwoQueue(root);
        System.out.println();

        System.out.println();
        System.out.println("Level order print line by line: use two queue.....");
        printLevelOrderTwoQueue(root);
        System.out.println();

        System.out.println();
        System.out.println("Level order print line by line: use one queue.....");
        printLevelOrderUseOneQueandCount(root);
        System.out.println();

    }
}
