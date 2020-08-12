package com.treeWork.quiz;

import java.util.LinkedList;
import java.util.Queue;

/*

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

 */
public class QuizRightView {


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
    private static void rightViewPrint(Node node) {
        if(node == null) return;
        Queue<Node> q1 = new LinkedList<>();
        q1.add(node);

        while(true){

            int levelNodeCount= q1.size();
            if(levelNodeCount==0) break;
            int val=0;
            while(levelNodeCount>0) {

                if (q1.peek().left != null) {
                    q1.add(q1.peek().left);

                }

                if (q1.peek().right != null) {
                    q1.add(q1.peek().right);
                }

                val = q1.remove().value;
                levelNodeCount--;
            }

            System.out.print(val + " ");
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

        System.out.println("Print Right View ...");

        rightViewPrint(root);
    }
}
