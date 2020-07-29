package com.homework.Recursive;
/*
Imagine a Robot sitting on the upper left corner of a grid with rows and columns.
The robot can only move in two directions, right and down. While moving the Robot can
accumulate points which are numbers in the grid. Give the maximum sum the Robot can accumulate
starting from the upper left corner to the bottom right of the grid.

Recursive Solution:
https://github.com/iqbalzaveri/namcctip/blob/master/com/recursion/MaxSumInMatrix.java

 */
public class HW6MatrixMaxSum2 {

    public int maxSumInMatrix(int[][] matrix) {
        return maxSumInMatrix(matrix, 0, 0);
    }

    public int maxSumInMatrix(int[][] matrix, int row, int col) {




        if(row == matrix.length-1 && col == matrix[0].length-1){ // base condition - corner last cell
            return matrix[row][col];
        }

        if(row == matrix.length-1){ // base condition - bottom row
            return matrix[row][col] + maxSumInMatrix(matrix, row,col+1);
        }


        if(col == matrix[0].length-1){ // base condition - rightmost col
            return matrix[row][col] + maxSumInMatrix(matrix, row+1,col);
        }

        int rightSum = matrix[row][col]+ maxSumInMatrix(matrix, row,col+1);
        int downSum = matrix[row][col]+ maxSumInMatrix(matrix, row+1,col);



        return Math.max(rightSum,downSum);
    }
}
