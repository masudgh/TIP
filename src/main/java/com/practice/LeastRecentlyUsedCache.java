package com.practice;



import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedCache {


    Map<String, Integer> cachae = new HashMap<>();

    public void set(int val, String key){
        cachae.put(key,val);
    }

    public int get(String key){
        return cachae.get(key);
    }

    public void limitCapacity(int limit){

    }

    public void evictionPolicy(){

    }

    public void removeLeastRecently(){

    }

}
