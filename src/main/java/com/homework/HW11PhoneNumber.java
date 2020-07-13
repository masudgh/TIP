package com.homework;

import java.util.HashMap;
import java.util.Map;

/*
Input phonenumber(string) return all possible string representation of the phone number.
char[] getStringForNumber(int d)
getStringForNumber(3) -> D,E,F


See attached image.

getStringForNumber(234) -> ADG, AEG, AFG, BDG, BEG, BFG, .....
 */

public class HW11PhoneNumber {

    private Map<Integer, String> map = new HashMap<>();


    public void printNumbers (int [] phoneNumer){
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrst");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        map.put(0,"");

        String result ="";
        printNumbers(phoneNumer, 0, result);

    }

    public void printNumbers (int[] phoneNumer, int i, String result){

        if(i == phoneNumer.length){
            System.out.println( result);
            return;
        }

        String  chars= map.get(phoneNumer[i]);

        for(int c = 0; c< chars.length(); c++){ // limit of choice
            char ch = chars.charAt(c);
            result+= ch;
            printNumbers(phoneNumer, i+1, result);
            result = result.substring(0,result.length()-1); // back tracking
        }

        return;


    }
}
