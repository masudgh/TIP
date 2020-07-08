package com.recursion.one;

public class Prob13ChangePi {
    public String changePi(String str) {
        if (str == null || str == "" ) return "";
        if( str.length() == 1) return str;

        String strPi =  str.substring(0,2);
        String str1 =   str.substring(0,1);
        String str2;
        if(str.length()==2){
            str2 = "";
        }else{
            str2 = str.substring(2);
        }

        if(strPi.equals( "pi")) {
            return "3.14"+changePi(str2);
        }else{
            return str1 + changePi(str.substring(1));
        }
    }

}
