package com.sorting;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Test2 {

    // Net time complexity O(n)
    private static void printTopKCandidate( char [] arr, int k){


        if (arr == null) return;
        if(arr.length ==0) return;

        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());

        char [] ascii = new char [256];  //Constant space

        for(int i=0; i< arr.length; i++){  //T complexity= O(n)
            ascii[arr[i]]++;
        }

        for( int i=0; i<256; i++){ //T complexity = O(log n)
            char ch = (char) i;

            if(map.containsKey ((int)(ascii[i] ) )){
                String val = map.get((int)(ascii[i]));
                map.put((int)(ascii[i]), ch+","+val);
            }else {
                map.put((int) (ascii[i]), String.valueOf(ch));  //
            }
        }

        int l=0;
        for(Map.Entry<Integer,String> entry : map.entrySet()) {  //T complexity = O(log n)
            if(l>=k) break;
            String value = entry.getValue();
            String [] vals = value.split(",");

            for(int j=0; j<vals.length; j++) {
                System.out.println(vals[j]);
            }
            l++;
        }
        System.out.println();
    }


    public static void main (String [] args){
       char [] candidates1 = {'c', 'c', 'a', 'c', 'd', 'e', 'd', 'a', 'd', 'b', 'd'};
       int k =3;
       printTopKCandidate(  candidates1,  k);

        char [] candidates2 = {'c', 'c', 'a', 'c', 'd', 'e', 'd', 'a', 'd', 'b', 'd', 'e', 'f'};
        k =3;
        printTopKCandidate(  candidates2,  k);


    }
}
