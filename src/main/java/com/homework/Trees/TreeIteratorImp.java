package com.homework.Trees;
/*


Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the
root node of a BST.
1. Calling next() will return the next smallest number in the BST.
2. Calling hasNext() should return whether the next element exists.
Both functions should run in average O(1) time and uses O(h) memory, where h is the height
of the tree.
[Iterator is a concept in higher level languages like C++ or Java. You probably can
tell what it is. If you want to know more, please feel free to Google for the concept.]
Solutions:
1. With parent pointer: http://stackoverflow.com/questions/12850889/in-order-iterator-forbinary-tree
2. Without parent pointer, but with stack:https://leetcode.com/discuss/20001/my-solutions-in3-languages-with-stack
Choice of the solution will depend on what the interviewer asks you to do. #2 is generally
preferred i.e. without assuming there is a parent pointer
 */

import java.util.Iterator;
import java.util.Stack;

public class TreeIteratorImp {

    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }


    static class TreeIterator  implements Iterator {

        Stack<Node> hightStack = new Stack<>();

        public TreeIterator(Node node) {
            init(node);
        }

        private void init(Node node){
            if(node !=null) {
                hightStack.push(node);
                init(node.left);
            }
        }

        public boolean hasNext() {
            return (hightStack.size() !=0);
        }


        public Node next() {
            Node tmp = hightStack.pop();

            if(tmp.right!=null ){
                init(tmp.right);
            }

            return tmp;
        }


    }

    static void iterateTree(Node root){

        TreeIterator treeIterator = new TreeIterator(root);

        while (treeIterator.hasNext()){
           System.out.println( treeIterator.next().value + " ");
        }

    }

    public static void main (String [] ags){

    /*
    Tree
             14
            / \
           13   15
          /     \
         5       20
        / \     /
       1   6  16

     */

        Node root = new Node(14);
        Node n1 = new Node (13);
        Node n2 = new Node (15);
        Node n3 = new Node (5);
        Node n4 = new Node (20);
        Node n5 = new Node (1);
        Node n6 = new Node (6);
        Node n7 = new Node (16);
        root.left = n1;
        root.right =n2;
        n1.left =n3;
        n2.right =n4;
        n3.left = n5;
        n3.right =n6;
        n4.left = n7;

        iterateTree(root);
    }
}
