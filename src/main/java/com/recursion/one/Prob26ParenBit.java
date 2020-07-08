package com.recursion.one;

public class Prob26ParenBit {
    public String parenBit(String str) {
        if (str.isEmpty()) return null;

        String str1 = str.substring(0,1);
        if(str1.equals("(")){
            return str1+helper(str.substring(1));
        }
        return parenBit(str.substring(1));

    }


    String helper(String str){
        if (str.isEmpty()) return "";
        String str1 = str.substring(0,1);
        String panS= "";
        if(!str1.equals(")")){
            panS = str1+ helper(str.substring(1));
            return panS;
        }
        return panS+str1;

    }
}
