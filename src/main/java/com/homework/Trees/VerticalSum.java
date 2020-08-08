package com.homework.Trees;

public class VerticalSum {

    /*

    Given a binary tree, print out all of its root-to-leaf paths one per line.
e.g. for a tree that's
1
2 3
4 5 6 7
Print:
1 2 4
1 2 5
1 3 6
1 3 7
(This is a simple problem, but really tests your understanding of recursion)
Solution: http://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leafpaths-one-per-line/

     */


    static class Node {
        Node left, right;
        int value;
        Node( int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }



    static void sumPath(Node node){

            sumPathHelper(node, new int [100], 0 );
    }


    static void sumPathHelper(Node node, int [] pathArr, int i){
        if(node ==null) return;

        pathArr[i] = node.value;
        i++;

        if(node.left ==null && node.right ==null){
            int sum = 0;
            for(int j=0; j < i; j++){
                sum += pathArr[j];
                System.out.print(pathArr[j] +" ");
            }
            System.out.print(" = " + sum);
            System.out.println();
        }else{

            sumPathHelper(node.left, pathArr,i);
            sumPathHelper(node.right, pathArr,i);
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

        System.out.println("All Path ...");
        sumPath(root);


             /*
    Tree
             4
            / \
           3   8
          /
         1
        / \
       15 16
          /
          10

     */

        Node rootLeft = new Node(4);
        n1 = new Node(3);
        n2 = new Node(8);
        n3 = new Node(1);

        n5 = new Node(15);
        n6 = new Node(16);
        n7 = new Node(10);

        rootLeft.left = n1;
        rootLeft.right = n2;
        n1.left = n3;
        n3.left = n5;
        n3.right = n6;
        n6.left = n7;

        System.out.println("All Path ...");
        sumPath(rootLeft);


        /*
    Tree
             4
              \
               3
              /
             1
            / \
           15 16
              /
             10

     */

        Node rootRight = new Node(4);
        n1 = new Node(3);
        n2 = new Node(8);
        n3 = new Node(1);

        n5 = new Node(15);
        n6 = new Node(16);
        n7 = new Node(10);

        rootRight.right = n1;
        n1.left = n3;
        n3.left = n5;
        n3.right = n6;
        n6.left = n7;

        System.out.println("All Path ...");
        sumPath(rootRight);
    }
}
