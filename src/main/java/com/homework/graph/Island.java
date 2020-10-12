package com.homework.graph;

/*
Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island.
For example, the below matrix contains 5 islands

Example:

Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1}
Output : 5
This is a variation of the standard problem: “Counting the number of connected components in an
undirected graph”.

Using DFS:
https://www.geeksforgeeks.org/find-number-of-islands/

Using BFS:
https://www.geeksforgeeks.org/islands-in-a-graph-using-bfs/
 */
public class Island {

    static int[][] directions ={
            {-1,0}, //up
            {1,0}, //down
            {0,-1}, //left
            {0,1}, //right
            {-1,-1}, //up left
            {1,1}, // down right
            {1,-1}, // down left
            {-1,1} // up right
    };

    public static void main(String args []){

        int [][] matrix5 = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println("count of island: "+ countIslands(matrix5));
    }


    static int countIslands(int [][] matrix){
        int count =0;
        for (int row =0; row < matrix.length ; row++){
            for(int col =0; col < matrix[0].length; col++){

                if(matrix[row][col] == 1) { // if it is 1 then can move to it, /not visited
                    dfs(matrix, row, col);
                    count++;
                }
            }
        }

        return count;
    }


    private static void dfs(int [][] matrix, int row, int col){
        matrix[row][col] =-1; //mark as visited

        for (int dir =0; dir< directions.length; dir++){
            int rowDirection = row + directions[dir][0]; // move row in all valid direction
            int colDirection = col + directions[dir][1]; // move col in all valid direction

            if( isValid(rowDirection,colDirection, matrix.length,matrix[0].length) // row and col are valid
                    && matrix[rowDirection][colDirection] == 1) // if it is 1 then can move to it, /not visited
                dfs(matrix, rowDirection, colDirection);
        }
    }

    private static boolean isValid(int rowDirection, int colDirection, int maxRow, int maxCol){

        if ( (rowDirection >=0  && rowDirection <  maxRow)
            && (colDirection>=0 && colDirection < maxCol)){
            return true;
        }
        return false;
    }
}
