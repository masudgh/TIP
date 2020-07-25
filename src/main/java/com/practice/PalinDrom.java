package com.practice;

public class PalinDrom {



    private static boolean isPalinDrom(String str){
        if(str == null) return false;
        if(str.isEmpty()) return false;
        int n =str.length();
        if(n == 1) return true;

        if (str.charAt(0) == str.charAt(n-1)){
            return isPalinDrom(str.substring(1,n-1));
        }else
            return false;

    }

    public static void main (String [] args){
       System.out.println( isPalinDrom("racecar") );
    }
}
