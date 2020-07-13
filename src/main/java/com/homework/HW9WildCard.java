package com.homework;

public class HW9WildCard {

    public void printWildCardMatch(String str){
        if(str.isEmpty()) return;
        printWildCardMatch(str, "", 0);
    }

    void printWildCardMatch(String str, String result, int i){
        if(i== str.length()){
            System.out.println(result);
            return;
        }

        while( str.charAt(i)=='1' || str.charAt(i)=='0' ){
            result = result + str.charAt(i);
            i++;
        }

        printWildCardMatch( str, result+"1", i+1);
        printWildCardMatch( str, result+"0", i+1);
        return;


    }
}
