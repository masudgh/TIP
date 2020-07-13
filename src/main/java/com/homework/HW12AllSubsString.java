package com.homework;

import java.util.ArrayList;
import java.util.List;
/*
eg. Input: "hello"
Output:
[h, e, l, l, o]
[h, e, l, lo]
[h, e, ll, o]
[h, e, llo]
[h, el, l, o]
[h, el, lo]
[h, ell, o]
[h, ello]
[he, l, l, o]
[he, l, lo]
[he, ll, o]
[he, llo]
[hel, l, o]
[hel, lo]
[hell, o]
[hello]
 */
public class HW12AllSubsString {


    public void printSubString( String str){

        printSubString(  str, new ArrayList<>(), 0);
    }

    public void printSubString(String str, List<String> result, int i){

        if (i== str.length() ){
            System.out.println(result);
            return;
        }

        List<String> results = new ArrayList<>();

        results.addAll(result);
        for(int j=i; j< str.length();j++) {
            String tmp = str.substring(i,j+1);
            results.add(tmp);
            printSubString(str, results, j+1);
            results.remove(tmp); // Backtrack
        }

    }



}
