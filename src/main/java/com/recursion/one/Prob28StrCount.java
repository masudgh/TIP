package com.recursion.one;

public class Prob28StrCount {
    public int strCount(String str, String sub) {
        if(str.isEmpty()) return 0;
        int subLen = sub.length();
        if(subLen > str.length()) return 0;
        int count =0;
        int nextLen = 1;
        String str1 = str.substring(0,subLen);
        if(str.substring(0,subLen).equals(sub)){
            count++;
            nextLen = subLen;
        }
        return count + strCount (str.substring(nextLen), sub);

    }

}
