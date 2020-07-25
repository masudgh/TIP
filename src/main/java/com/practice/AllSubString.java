package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubString {

    private static void printAllSubString (String str){
        if(str == null) return;
        if(str.isEmpty()) return;
       // printAllSubString(str,0,new char[0] );
        printAllSubString(str,new ArrayList<>(), 0 );
    }

    /*
     method 1

     */
    private static void printAllSubString (String str, int i, char[] target){

        if(i == str.length()){
            System.out.println( String.valueOf(target));
            return;
        }

        char [] newTarget = new char [ target.length +1] ;
        for(int j=0; j < target.length; j++){
            newTarget[j] = target [j];
        }
        newTarget[target.length] = str.charAt(i);

        printAllSubString(str,i+1,target );
        printAllSubString(str,i+1,newTarget );

    }


     /*
     method 2 - Permutation

     */

    private static void printAllSubString (String str, List<String> results, int i){

        if(i== str.length()){
            System.out.println(results);
            return;
        }

        List<String> newResult = new ArrayList<>();

        newResult.addAll(results);

        for(int j =i; j< str.length(); j++) {
            String tmp = str.substring(i,j+1);
            newResult.add(tmp);
            printAllSubString(str, newResult, j+1);
            newResult.remove(tmp);
        }
    }




    public static void main (String [] args){
        printAllSubString("hello");
    }

}
