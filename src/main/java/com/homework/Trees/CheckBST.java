package com.homework.Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Is it a BST?

Very common mid-tier interiew question.

https://leetcode.com/problems/validate-binary-search-tree/discuss/32104/
c-in-order-traversal-and-please-do-not-rely-on-buggy-int_max-int_min-solutions-any-more

 */
public class CheckBST {

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

    static boolean isBST(Node node){
        if(node == null) return false;

        if(node.left !=null && node.right !=null) {
            if(isRightBranchBST(node.right, node) && isLeftBranchBST(node.left, node))
                return isBST(node.left) && isBST(node.right);
            else
                return false;
        }else if (node.left !=null){
            return isBST(node.left);
        }else if (node.right !=null) {
            return isBST(node.right);
        }


        return true;
    }


    static boolean isRightBranchBST(Node node , Node parent){

        if (parent.value < node.value){
            if(node.left ==null && node.right ==null) return true;
            if (node.left !=null) return isRightBranchBST(node.left, parent);
            else
                return isRightBranchBST(node.right, parent);

        }
        return false;
    }

    static boolean isLeftBranchBST(Node node , Node parent){

        if (parent.value > node.value){
            if(node.left ==null && node.right ==null) return true;
            if (node.left !=null) return isLeftBranchBST(node.left, parent);
            else
                return isLeftBranchBST(node.right, parent);

        }
        return false;
    }

    public static void main (String [] ags) {

    /*

    8VN7LBLzg23M%

    bk8bTf39#K
    Tree
             20
            / \
           15  22
          /     \
         10      30
        / \     /
       5  11   25

     */

        Node root = new Node(20);
        Node n1 = new Node(15);
        Node n2 = new Node(22);
        Node n3 = new Node(10);
        Node n4 = new Node(30);
        Node n5 = new Node(5);
        Node n6 = new Node(11);
        Node n7 = new Node(25);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n2.right = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;


        System.out.println("Original Tree BST : ");
        printLevelOrderUseOneQueandCount(root);
        System.out.println(isBST(root));

         /*
    Tree -unbalanced, not a BST
             20
            / \
           15  22
          /     \
         10      30
        / \     /
     500  11   25

     */

        System.out.println("==========>");
        System.out.println("Original Tree non-BST: ");
        Node n500 = new Node(500);
        n3.left = n500;
        printLevelOrderUseOneQueandCount(root);
        System.out.println(isBST(root));

    }
}
