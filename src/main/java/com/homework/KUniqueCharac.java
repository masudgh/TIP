package com.homework;

import java.util.HashMap;
import java.util.Map;

public class KUniqueCharac {

    private static void printUnique(String str, int k){
        Map<Character, Integer> charFreq = new HashMap<>();

        int left =0;
        int right =0;

        for(int i=0; i < str.length(); i++){
            char rightChar = str.charAt(right);
            charFreq.put(rightChar, charFreq.getOrDefault(rightChar,0)+1);

            while(charFreq.size()>k){
                char leftChsr = str.charAt(left);
                charFreq.put(rightChar, charFreq.getOrDefault(rightChar,0)+1);
            }
        }

    }

    public static void main(String [] args){


        printUnique("abcddffeldjfgdfg", 3);

    }
}
