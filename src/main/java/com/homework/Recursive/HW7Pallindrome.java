package com.homework.Recursive;
/*
Write a function isPalindrome() that takes a String as an input and returns
True if the string is a palindrom otherwise False. Solve this using recursion. Do not use any loops.

eg.
isPalindrome("racecar") --> True
isPalindrome("abba") --> True
isPalindrome("a") --> True
isPalindrome("hello") --> False
isPalindrome("ax") --> False
 */
public class HW7Pallindrome {

    public boolean isPalindrome(String str){

        if(str==null) return false;
        if(str.equals("") ||  str.length()==1) return true;

        if (str.charAt(0) == str.charAt(str.length()-1)){
            return isPalindrome(str.substring(1,str.length()-1));
        }else return false;
    }

}
