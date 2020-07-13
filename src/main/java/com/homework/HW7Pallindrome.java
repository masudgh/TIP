package com.homework;

public class HW7Pallindrome {

    public boolean isPalindrome(String str){

        if(str==null) return false;
        if(str.equals("") ||  str.length()==1) return true;

        if (str.charAt(0) == str.charAt(str.length()-1)){
            return isPalindrome(str.substring(1,str.length()-1));
        }else return false;
    }

}
