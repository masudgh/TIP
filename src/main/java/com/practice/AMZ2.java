package com.practice;

public class AMZ2 {


     public  static int maxSumInMatrix(int[][] matrix, int row, int col) {
        if(row == matrix.length-1 && col == matrix[0].length-1) { //base condition 1 -- last cell
            if(matrix[row][col] ==1) return 0;
            else return 1;
        }

        if(row == matrix.length-1) { //base condition 2 -- end of row
            if(matrix[row][col] ==1) return  0;  //maxSumInMatrix(matrix, row, col+1);
            return 1 + maxSumInMatrix(matrix, row, col+1);
        }

        if(col == matrix[0].length-1) { //base condition 3 -- end of column
            if(matrix[row][col] ==1) return 0; //maxSumInMatrix(matrix, row+1, col);
            return 1 + maxSumInMatrix(matrix, row+1, col);
        }
         int rightSum,downSum;
         if( matrix[row][col] ==1) {
             rightSum = maxSumInMatrix(matrix, row, col + 1);
             downSum =  maxSumInMatrix(matrix, row+1, col);
         }else {
             rightSum = 1 + maxSumInMatrix(matrix, row, col + 1);
             downSum = 1 + maxSumInMatrix(matrix, row+1, col);
         }




        return Math.max(rightSum, downSum);

    }



   /*
    static int getPath(int [][] maze, int r, int c){


        int rightSum,downSum,leftSum,upSum;

        // first  top most corner  cell
        if(r == 0 && c == 0) {
            if ( maze[r][c] !=1)
                return 1 + Math.max(getPath(maze, r, c + 1), getPath(maze, r+1, c ));
            else
                return + Math.max(getPath(maze, r, c + 1), getPath(maze, r+1, c ));
        }


        // first  base condition - corner most cell
        if(r == maze.length-1 && c == maze[0].length-1) {
            if ( maze[r][c] !=1)
                return 1;
            else
                return 0;
        }


        //base condition -lowest of row
        if( (r == 0 || r == maze.length-1) && (( maze[0].length-1) >= c )){
            if(maze[r][c] !=1) {
                return 1 + Math.max(getPath(maze, r, c + 1), getPath(maze, r, c - 1));
            }else{
                return Math.max(getPath(maze, r, c + 1), getPath(maze, r, c - 1));
            }
        }



        //base condition- 1st or end of col
        if ((c == 0 || c == maze[0].length-1) && ((maze.length-1) >=r ) )  {
            if(maze[r][c] !=1) {
                return 1 + Math.max(getPath(maze, r + 1, c), getPath(maze, r - 1, c));
            }else
                return Math.max(getPath(maze, r + 1, c), getPath(maze, r - 1, c));
        }
        if(( c <= maze[0].length-1) && (r <= maze.length-1)) {
            if (maze[r][c] != 1) {
                rightSum = 1 + getPath(maze, r, c + 1);
                downSum = 1 + getPath(maze, r + 1, c);

                leftSum = 1 + getPath(maze, r, c - 1);
                upSum = 1 + getPath(maze, r - 1, c);
            } else {
                rightSum = getPath(maze, r, c + 1);
                downSum = getPath(maze, r + 1, c);

                leftSum = getPath(maze, r, c - 1);
                upSum = getPath(maze, r - 1, c);
            }
        }


        return Math.max(Math.max(rightSum, downSum), Math.max(leftSum, upSum));
    }
*/
    public static void main(String[] args) {
        int [] [] maze  = {{0,0,0,0},{1,0,1,0},{0,1,0,0},{0,0,0,1}};

        System.out.println ( maxSumInMatrix(maze,0,0));
    }

}
