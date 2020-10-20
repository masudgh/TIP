package com.dynamic;


/*
Given a matrix mat[][] of dimensions N * M, the task is to find the path from the top-left cell (0, 0) to the bottom-right cell (N – 1, M – 1) of the given matrix such that sum of the elements in the path is maximum. The only moves allowed from any cell (i, j) of the matrix are (i + 1, j) or (i, j + 1).

Examples:

Input: mat[][] = {{3, 7}, {9, 8}}
Output: 20
Explanation:
Path with maximum sum is 3 => 9 => 8 as 20.

Input: mat[][] = {{1, 2}, {3, 5}}
Output: 9
Explanation:
Path with maximum sum is 1 => 3 => 5 as 9

 */
public class MaxSum {

    static int[][] directions ={
            {0,1}, //right
            {1,0} //down
    };

    private static int maxSumDP( int [] [] matrix){

        int [][] dp = new int [matrix.length][matrix[0].length];
        int row = matrix.length-1;
        int col = matrix [0].length -1;
     //   System.out.println(row+","+col);
        dp [row][col] = matrix[row][col]; // base case 1

        for(int c=col-1; c>=0 ; c--){
            dp [row][c] = matrix[row][c] + matrix[row][c+1]; // base cond 2
        }

        for(int r=row-1; r>=0 ; r--){

            dp[r][col] = matrix[r][col] + matrix[r+1][col];  // base cond 3
        }


        for(int r=row-1; r>=0 ; r--){
            for(int c=col-1; c>=0 ; c--) {
                int rightSum = matrix[r][c] + dp [r][c+1];
                int downSum = matrix[r][c] + dp [r+1][c];

           /*     if(rightSum>downSum){
                    System.out.println(r+","+c+1);
                }else{
                    System.out.println(r+1+","+c);
                }*/

                dp[r][c] = Math.max(rightSum, downSum) ; // base cond 4
            }
        }

      //  System.out.println("0,0");
        return dp[0][0];

    }






    public static void main (String [] args){

        int [] [] matrix = {
                { 2,1,2 },
                { 1,3,1},
                { 2,1,4},
                { 1,1,3}
        };

        int [] [] arr = {
                { 1,2,3 },
                { 4,5,6},
                { 7,8,9}
        };


        int [] [] arr2 = {
                { 3,7 },
                { 9,8}
        };

        System.out.print(maxSumDP(arr));


    }
}
