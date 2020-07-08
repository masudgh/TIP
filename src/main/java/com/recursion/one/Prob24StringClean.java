package com.recursion.one;

public class Prob24StringClean {

    public String stringClean(String str) {
        if (str == null || str == "" ) return "";

        if( str.length() == 1) return str;

        String str1 = str.substring(0,1);
        String str2 = str.substring(1,2);
        String str3;

        if(str.length()==2)
            str3 ="";
        else
            str3 = str.substring(2);

        if(str1.equals(str2))
            return str1+ stringClean(cleanRepeat(str3, str1));
        else
            return str1+ stringClean(str.substring(1));

    }


    String cleanRepeat(String str, String str1){
        if (str == null || str == "" ) return "";
        String tmp = str.substring(0,1);
        if(tmp.equals(str1))
            return cleanRepeat(str.substring(1), str1);
        else return str;
    }


}
