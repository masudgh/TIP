package com.recursion.one;

public class Prob18AllStar {

    public String allStar(String str) {

        if (str == null || str == "" ) return "";
        if( str.length() == 1) return str;
        String str1 = str.substring(0,1);
        String str2 = str.substring(1);


        return str1+"*"+allStar(str2);
    }

}
