package com.homework.Trees;

/*
Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined
as the lowest node in T that has both n1 and n2 as descendants.
The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the
root. Computation of lowest common ancestors may be useful, for instance, as part of a
procedure for determining the distance between pairs of nodes in a tree: the distance from n1
to n2 can be computed as the distance from the root to n1, plus the distance from the root to
n2, minus twice the distance from the root to their lowest common ancestor. (Source:
Wikipedia)
Design an write an algorithm to find the LCA node, given two nodes in a Binary Tree.
* The tree may or may not be a BST
* Assume a Node structure that has NO parent pointer
* Assume that the two nodes are distinct and exist in the tree
* Find a solution that has runtime complexity of O(N). N is # nodes in the tree.
*
 */
public class CommonAncestor {


    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }

    static Node findCommonAncestor( Node root, Node n1, Node n2){
        if(root == null) return null;

        if(compareNode(root, n1) && compareNode(root,n2)) return root;

        Node left = findCommonAncestor(root.left, n1, n2);
        Node right = findCommonAncestor(root.right, n1, n2);

        if(left !=null) return left;
        else if (right !=null) return right;
        else if (compareNode(left, n1) && compareNode(left,n2)) return left;
        else if (compareNode(right, n1) && compareNode(right,n2)) return right;
        else return null;
    }


    static boolean compareNode (Node n1, Node n2){
        return  n1.value == n2.value;
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

        Node tmp = findCommonAncestor(root, n5,n7);

        System.out.println(tmp.value);
    }


}
