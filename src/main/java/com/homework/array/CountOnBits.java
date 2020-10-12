package com.homework.array;

import java.util.HashMap;
import java.util.Map;

public class CountOnBits {

    public static int getCount(int [] arr){
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: arr) {
            while (n != 0) {
                n = n & n - 1;

                if(map.containsKey(n))
                {
                    return (count + map.get(n));
                }else{
                    count ++;
                    map.put(n, count);
                }
            }
        }
        System.out.println(count);
        return count;


    }

    public static void main (String [] args){
        int [] arr = { 4,3};
        getCount(arr);
    }
}
