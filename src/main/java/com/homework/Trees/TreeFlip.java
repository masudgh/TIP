package com.homework.Trees;


import java.util.LinkedList;
import java.util.Queue;

/*
Reverse a general binary tree, i.e. flip it from right to left.
So for example if we had the binary tree
6
/ \
3 4
/ \ / \
7 3 8 1
Reversing it would create
6
/ \
4 3
/ \ / \
1 8 3 7

https://stackoverflow.com/questions/9460255/reverse-a-binary-tree-left-to-right


 */

public class TreeFlip {

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


    static void flipTree(Node n1){

        if(n1 == null ) return;

        Node tmp = n1.left;
        n1.left = n1.right;
        n1.right = tmp;

        if(n1.left !=null){
            flipTree(n1.left);
        }

        if(n1.right !=null){
            flipTree(n1.right);
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

        System.out.println("Print original Tree: ");
        printLevelOrderUseOneQueandCount(root1);
        flipTree(root1);
        System.out.println("Print flipped Tree: ");
        printLevelOrderUseOneQueandCount(root1);



        /*
    Tree
             4
            / \
           3   8
              / \
             7   9
                  \
                  12
                   \
                    15
     */

        Node root2 = new Node(4);
        Node n10 = new Node(3);
        Node n11 = new Node(8);
        Node n20 = new Node(7);
        Node n21 = new Node(9);
        Node n31 = new Node(12);
        Node n41 = new Node(15);


        root2.right = n11;
        root2.left = n10;
        n11.right = n21;
        n11.left = n20;
        n21.right = n31;
        n31.right = n41;

        System.out.println("Print original Tree: ");
        printLevelOrderUseOneQueandCount(root2);
        flipTree(root2);
        System.out.println("Print flipped Tree: ");
        printLevelOrderUseOneQueandCount(root2);

    }
}
