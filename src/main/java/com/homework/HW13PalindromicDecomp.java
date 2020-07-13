package com.homework;

import java.util.ArrayList;
import java.util.List;

public class HW13PalindromicDecomp {

    /*
    A “Palindromic Decomposition” of string S, is a decomposition of the string into substrings,
    such that all those substrings are valid palindromes. A single character is considered a valid
    palindrome for this problem. Print out all possible palindromic decompositions of a given
    string.
e.g.
Input: abracadabra
Output:
a|b|r|a|c|a|d|a|b|r|a|
a|b|r|a|c|ada|b|r|a|
a|b|r|aca|d|a|b|r|a|
     */

    public boolean isPalindrome(String str){

        if(str==null) return false;
        if(str.equals("") ||  str.length()==1) return true;

        if (str.charAt(0) == str.charAt(str.length()-1)){
            return isPalindrome(str.substring(1,str.length()-1));
        }else return false;
    }

    public void printPalindrom(String str) {

        printPalindrom(str,new ArrayList<>(),0);
    }

    public void printPalindrom(String str, List<String> result, int i) {

        if (i== str.length() ){
            String str1 ="";
            int k = 0;
            for(String tmp: result){
                if(isPalindrome(tmp)){
                    if(k==0)
                        str1 = tmp + "|";
                    else
                        str1 +=   tmp + "|";
                    k++;
                }
            }

            if(!str1.isEmpty() && (k == result.size() ) ) {
                System.out.println(str1.substring(0,str1.length()-1));
            }
            return;
        }

        List<String> results = new ArrayList<>();

        results.addAll(result);
        for(int j=i; j< str.length();j++) {
            String tmp = str.substring(i,j+1);
            results.add(tmp);
            printPalindrom(str, results, j+1);
            results.remove(tmp); // Backtrack

        }
    }

}

