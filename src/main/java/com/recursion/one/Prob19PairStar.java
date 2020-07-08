package com.recursion.one;

public class Prob19PairStar {
    public String pairStar(String str) {
        if (str == null || str == "" ) return "";
        if (str == null || str == "" ) return "";
        if( str.length() == 1) return str;

        String str1 = str.substring(0,1);
        String str2 = str.substring(1,2);


        String str3 = str.substring(1);

        if(str1.equals(str2))
            return str1+"*"+ pairStar(str3);
        else
            return str1+ pairStar(str3);
    }

}
