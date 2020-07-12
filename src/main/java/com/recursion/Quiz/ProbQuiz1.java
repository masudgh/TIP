package com.recursion.Quiz;

public class ProbQuiz1 {
    public boolean isPalindrome(String str){

        if(str==null) return false;
        if(str.length()==1) return true;
        if (str.charAt(0) == str.charAt(str.length()-1)){
            return isPalindrome(str.substring(1,str.length()-1));
        }else return false;
    }

}
