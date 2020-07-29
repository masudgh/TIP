package com.recursion.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz3 {

    private static void  getValidSentense( String str, List<String> wordDict ){

         printSubString(  str, new ArrayList<>(), 0, wordDict);
    }

    private static void printSubString(String str, List<String> result, int i, List<String> wordDict){

        if (i== str.length() ){
            String retStr = result.stream()
                                   .collect(Collectors.joining(" "));
            System.out.println(retStr);
            return ;
        }

        List<String> results = new ArrayList<>();

        results.addAll(result);
        for(int j=i; j< str.length();j++) {
            String tmp = str.substring(i,j+1);
            if(wordDict.contains(tmp)) {
                results.add(tmp);
                printSubString(str, results, j + 1, wordDict);
                results.remove(tmp); // Backtrack
            }
        }
    }


    public static void main (String [] args){
        //Test 1
        List <String> wordDict1 = new ArrayList <String> (){{
            add("cat");
            add("cats");
            add("and");
            add("sand");
            add("dog");
        }};

        String str1 = "catsanddog";

         getValidSentense(str1, wordDict1);


        //Test 2
        List <String> wordDict2 = new ArrayList <String> (){{
            add("apple");
            add("pen");
            add("applepen");
            add("pine");
            add("pineapple");
        }};

        String str2 = "pineapplepenapple";

        getValidSentense(str2, wordDict2);



        //Test 3
        List <String> wordDict3 = new ArrayList <String> (){{
            add("cats");
            add("dog");
            add("sand");
            add("and");
            add("cat");
        }};

        String str3 = "catsandog";

         getValidSentense(str3, wordDict3);



    }

}
