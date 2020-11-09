package com.dynamic;

/*
Given two words word1 and word2, find the minimum number of steps required to
convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
e.g. Minimum edit distance between the words 'kitten' and 'sitting', is 3
kitten → sitten (substitution of "s" for "k")
sitten → sittin (substitution of "i" for "e")
sittin → sitting (insertion of "g" at the end)

(Assume all inputs and substitutions in lower case)
More about Levenshtein Distance: https://en.wikipedia.org/wiki/Levenshtein_distance
Solution: http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/

https://www.youtube.com/watch?v=AuYujVj646Q
 */
public class LevenshteinDistance {


    //Match the second string with first string, find out fow many operation will be needed
    private static int minOperation(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        int [] [] dp = new int [m+1][n+1];

        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++) {

                // If first string is empty, only option is to
                // INSERT all characters of second string
                if (i == 0) {
                    dp[i][j] = j; // Min. operations = j
                }
                // If second string is empty, only option is to
                // REMOVE all characters of second string
                else if (j == 0) {
                    dp[i][j] = i; // Min. operations = i
                }
                // If last characters are same, ignore last char
                // and recur for remaining string
                else if (  str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If the last character is different, consider all
                // possibilities and find the minimum
                else {
                    dp[i][j] = 1 + Math.min ( dp[i][j - 1], // Insert
                                    Math.min (dp[i - 1][j], // Remove
                                    dp[i - 1][j - 1]) // Replace
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String [] args){
       // System.out.println(minOperation("Sunday","Saturday"));
        System.out.println(minOperation("kitten","sitting"));
    }
}
