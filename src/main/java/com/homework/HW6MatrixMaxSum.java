package com.homework;

public class HW6MatrixMaxSum {

    public int maxSumInMatrix(int[][] matrix) {
        return maxSumInMatrix(matrix, 0, 0);
    }

    public int maxSumInMatrix(int[][] matrix, int row, int col) {
        if(row == matrix.length-1 && col == matrix[0].length-1) { //base condition 1 -- last cell
            return matrix[row][col];
        }

        if(row == matrix.length-1) { //base condition 2 -- end of row
            return matrix[row][col] + maxSumInMatrix(matrix, row, col+1);
        }

        if(col == matrix[0].length-1) { //base condition 3 -- end of column
            return matrix[row][col] + maxSumInMatrix(matrix, row+1, col);
        }

        int rightSum = matrix[row][col] + maxSumInMatrix(matrix, row, col+1);
        int downSum = matrix[row][col] + maxSumInMatrix(matrix, row+1, col);

        return Math.max(rightSum, downSum);

    }
}
