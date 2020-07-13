package com.homework;

import java.util.ArrayList;
import java.util.List;

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
