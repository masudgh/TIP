package com.llstq;


/*

Find the length of the longest substring (contiguous) that has matching opening and closing
parentheses. We only need length, not the substring itself. You may assume valid input for the
purpose of this exercise i.e. Input string can only have parentheses and nothing else.
e.g.
1. Input: "((((())(((()", Output: 4, for "(())"
2. Input: "(((((", Output: 0, for ""
3. Input: "()()()", Output: 6, for "()()()"
4 Input: "", Output: 0, for ""

 */


import java.util.Stack;

public class LongestSubString {


    private static int findLongestSubString(String str){
        int mxLength =0;
        for(int i=0; i<str.length(); i++) {
            int curLength = helperLongestSubString(str.substring(i),0) ;
            if( mxLength < curLength){
                mxLength = curLength;
            }
        }
        return mxLength;
    }

    private static int helperLongestSubString(String str, int start){
        if(str == null || str.isEmpty()) return 0;

        Character OPENING_PARENTHESIS = '(';

      //  Stack<Character> stack = new Stack<>();

        int i =0;
        int maxLength = 0;
        int currLength = 0;


        while(i< str.length()){
            Character curr = str.charAt(i++);
            if(curr == OPENING_PARENTHESIS)
                currLength++;
            else
                currLength--;

            if( currLength == 0 )
                maxLength =  i;
        }

        return start+ maxLength;
    }


    public static void main (String [] args){

        String str ;
        str = "((((())(((()";
        str = "(((((";
        str ="()()()";
        str ="";
        System.out.println( "Longest () : " + findLongestSubString(str) );

    }


}
