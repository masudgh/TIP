package com.homework.graph;


import com.homework.trie.SimpleTrie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*
This is an age-old question, which leads to some excellent discussions in an interview. Here, you're
essentially comparing one set of strings to another set of strings. As you try to solve it, you'll go thru
various approaches e.g. hashing the strings, sorting and binary search, tries, recursion (DFS), and
even BFS:
Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character.
Find all possible words that can be formed by a sequence of adjacent characters. Note that
we can move to any of 8 adjacent characters, but a word should not have multiple instances of same
cell. Get all possible such words and return them.
Example:

Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
       boggle[][]   = {{'G', 'I', 'Z'},
                       {'U', 'E', 'K'},
                       {'Q', 'S', 'E'}};
      isWord(str): returns true if str is present in dictionary
                   else false.

Output:  Following words of dictionary are present
         GEEKS
         QUIZ

This is easy to understand, but is inefficient compared to using a
Trie: http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/

This uses a Trie: http://stackoverflow.com/a/746102/327310 (This is what is
expected in an interview)
 */




class BoggleSolver {

    int[][] directions ={
            {0,1}, //right
            {0,-1}, //left
            {-1,-1}, //up left
            {-1,0}, //up
            {1,0}, //down
            {1,1}, // down right
            {1,-1}, // down left
            {-1,1} // up right
    };

    SimpleTrie trie;



    public BoggleSolver(String [] dictionary) {

        this.trie = new SimpleTrie();
        if(dictionary != null) {
            for(int i=0; i<dictionary.length; i++)
                trie.insert(dictionary[i]);
        }

    }

    public void findWords( char [][] boggle){
        int nRow = boggle.length;
        int nCol = boggle[0].length;

        boolean [][] isVisited = new boolean[nRow][nCol];

        for(int r = 0; r < nRow; r++){
            for (int c =0; c< nCol; c++){
                findWords ( boggle, isVisited,  r, c, "" );
            }
        }

    }


    private void findWords (char [][] boggle, boolean [][] isVisited,int row, int col, String str){

        isVisited[row][col] = true;
        str = str + boggle[row][col];

        if(str == "GIZ"){
            System.out.println(str);
        }

        if(trie.isWordExist(str)){ //If word present in the dictionary , print it
            System.out.println(str);
        }

        for(int i =0; i<8; i++ ){
           int newRow = row + directions[i][0];
           int newCol = col + directions[i][1];



                if (isValid(newRow, newCol, boggle.length, boggle[0].length)
                        && !isVisited[newRow][newCol] ) {

                    findWords(boggle, isVisited, newRow, newCol, str);
                }
            }

        str = "" + str.charAt(str.length() - 1); //back track string
        isVisited[row][col] = false; //back track isVisited to false
    }


    private boolean isValid(int newRow, int newCol, int rowN, int colN){

        if ( (newRow >= 0 && newRow < rowN) &&
                (newCol >=0 && newCol < colN)) {
            return true;
        }

        return false;
    }

}



public class BoggleSolverDemo {

    static final String[] dictionary = { "GEEKS", "FOR", "QUIZ", "GO" };

    public static void main (String [] args){

     /*   char [] [] matrix = {
                {'F', 'X', 'I', 'E'},
                {'A', 'M', 'L', 'O'},
                {'E', 'W', 'B', 'X'},
                {'A', 'S', 'T', 'U'}
        };
    */
         char [] [] boggle = {
                 { 'G', 'I', 'Z' },
                 { 'U', 'E', 'K' },
                 { 'Q', 'S', 'E' }};

        BoggleSolver boggleSolver = new BoggleSolver(dictionary);

        boggleSolver.findWords(boggle);

    }






}
