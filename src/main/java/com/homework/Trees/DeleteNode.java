package com.homework.Trees;


import java.util.LinkedList;
import java.util.Queue;

/*
Give a root node and an integer value in the BST, delete the node.
 */
public class DeleteNode {

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


    static Node searchMinOfTree(Node node){

        if(node.left == null) return node;
        return searchMinOfTree( node.left);
    }


    static Node deleteAndBalanceTree( Node node, int delVal) {
        if (node == null) return null;


        if (delVal == node.value) {
            if (node.left != null && node.right != null) { // Both child exist - check
                // search and get minimum value from the right tree
                Node tmp = node;

                Node minNode = searchMinOfTree(tmp.right);

                node.value = minNode.value;
                node.right = deleteAndBalanceTree(node.right,minNode.value);

            } else if (node.left != null) { // Get the lowest from the right branch
                node =node.left;
           }else if (node.right != null) { // Get the lowest from the left branch
                node =node.right;
            }else{  //Leaf condition
                node= null;
            }
        }else if (delVal > node.value) {  // move right
            node.right = deleteAndBalanceTree(node.right, delVal);
        } else {  // move left
            node.left = deleteAndBalanceTree(node.left, delVal);
        }
        return node;
    }




    public static void main (String [] ags) {

    /*
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


        System.out.println("Original Tree: ");
        printLevelOrderUseOneQueandCount(root);

        Node modRoot = deleteAndBalanceTree(root,22);

        System.out.println("=================>");
        System.out.println("Re balance Tree: ");
        printLevelOrderUseOneQueandCount(modRoot);

    }
}
