package com.homework.strings;

/*

Given a string, find the length of the longest substring T that contains at most 2 distinct
characters.
For example, Given s = “eceba”,
T is "ece" which its length is 3.
* IF there are no such substrings (all same characters), then print nothing
* If there multiple such strings, then print any one
Solution: Take inspiration from: http://www.geeksforgeeks.org/find-the-longest-substring-withk-unique-characters-in-a-given-string/

 */

import java.util.Arrays;

public class LongestSubString {

    private static int MAX_CHARS = 26;


    // Sliding window solution
    private static int kUniqueStr ( String str, int k){
        if (str == null ||  str.length() == 0) return 0;

        int n = str.length();
        int [] charSet = new int [MAX_CHARS];
        Arrays.fill(charSet,0);


        int uniqueCharCount =0;
        for(int i=0; i< n; i++){  // O(n)
            if (charSet[ str.charAt(i) - 'a'] == 0){
                uniqueCharCount ++;
            }
            charSet[ str.charAt(i) - 'a']++;
        }

        if(uniqueCharCount<k) return 0;  // Not enough unique character in the whole string

        Arrays.fill(charSet,-1);


        int start =0;
        charSet[str.charAt(0) - 'a']= start; // First character from string
        int maxSubStrLength=0;
        for (int end=1; end <n; end++){
            char c = str.charAt(end);

            if(charSet[c-'a'] >= 0) {// the character is already there
                // move start
                start = charSet[c -'a']+1;
            }
            charSet[c - 'a']=end; //put the position of c in the container
            if( isValid(charSet,k) )
                 maxSubStrLength = Math.max(maxSubStrLength, end-start+1);

        }


        return maxSubStrLength;
    }


    static boolean isValid(int count[], int k) {
        int val = 0;
        for (int i = 0; i < MAX_CHARS; i++) {
            if (count[i] >= 0) {
                val++;
            }
        }

        // Return true if k is greater than or equal to val
        return (k >= val);
    }


    // O(n^2 Brut force solution
    private static int kUniqueStr1 ( String str, int k){

        if (str == null ||  str.length() == 0) return 0;

        int n = str.length();
        int [] charSet = new int [MAX_CHARS];

        int maxSubStrCount=0;
        for(int i =0; i< n; i++){

            int count =0;
            Arrays.fill(charSet,0);


            for(int j =i; j< n; j++) {
                if (charSet[ str.charAt(j) - 'a'] == 0){
                    count ++;
                }
                charSet[ str.charAt(j) - 'a']++;
                if(count == k){
                    maxSubStrCount++;
                }
            }
        }

        return maxSubStrCount;
    }



    public static void main (String [] args){
        int count =0;

        System.out.println("Bruit force: ");
        count = kUniqueStr1("abc", 2);
        System.out.println("Count of longest substring of 'abc' with at most 2 distinct character: " + count);


        count = kUniqueStr1("aaa", 2);
        System.out.println("Count of longest substring of 'aaa' with 2 distinct character: " + count);

        count = kUniqueStr1("eceba", 3);
        System.out.println("Count of longest substring of 'eceba' with 3 distinct character: " + count);

        System.out.println("Improved Method: ");
        count = kUniqueStr("abc", 2);
        System.out.println("Count of longest substring of 'abc' with 2 distinct character: " + count);


        count = kUniqueStr("aaa", 2);
        System.out.println("Count of longest substring of 'aaa' with 2 distinct character: " + count);

        count = kUniqueStr("eceba", 3);
        System.out.println("Count of longest substring of 'eceba' with 3 distinct character: " + count);

    }
}
