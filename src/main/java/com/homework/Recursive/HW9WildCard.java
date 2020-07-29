package com.homework.Recursive;
/*
Input: 10?
Output: 101, 100
i.e. ? behaves like a wild-card. There are two possibilities for 10?, when that ? is replaced with
either 0 or 1.
Input: 1?0?
Output: 1000, 1001, 1100, 1101
Please write a program that takes given strings as input and produces the suggested output.
Suggested time: 20 minutes.
 */
public class HW9WildCard {

    public void printWildCardMatch(String str){
        if(str.isEmpty()) return;
        printWildCardMatch(str, "", 0);
    }

    void printWildCardMatch(String str, String result, int i){
        if(i== str.length()){
            System.out.println(result);
            return;
        }

        while( str.charAt(i)=='1' || str.charAt(i)=='0' ){
            result = result + str.charAt(i);
            i++;
        }

        printWildCardMatch( str, result+"1", i+1);
        printWildCardMatch( str, result+"0", i+1);
        return;


    }
}
