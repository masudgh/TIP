package com.practice;


import java.util.*;

public class TopKThString {


    class StrObj  {
        String str;
        int count;


    }


    //Do brut force
    // use bucket sort

    public static List<String> findKthStrings1(List<String> arr, int k){
        List<String> kthArr = new ArrayList<>();

        List<String> sortedStr = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for(String str: arr){
            int count = 0;
            if(map.containsKey(str)) count = map.get(str);
            if(count == 0)
                map.put(str,1);
            else
                map.put(str,count+1);
        }



        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> {
                    sortedStr.add(x.getKey());
                });

        int j =0;
        for(int i=sortedStr.size()-1; i>-1; i--){

            if(j<k) {
                kthArr.add(sortedStr.get(i));
                j++;
            }
        }
        return kthArr;
    }


    // Use Bucket
    public static List<String> findKthStrings2(List<String> arr, int k){
        List<String> kthArr = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int maxLen =0;
        for(String str: arr){
            int count = 0;
            if(map.containsKey(str)) count = map.get(str);
            if(count == 0)
                map.put(str,1);
            else {
                count++;
                map.put(str, count);
            }
            if(count> maxLen)  maxLen = count;
        }

        String [] bucket = new String [maxLen+1];  //Create bucket

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int index = entry.getValue();
            String val = entry.getKey();

            String maxStr =null;
            if (bucket[index] == null) {
                maxStr =  val;
            } else {
                maxStr = bucket[index];
                maxStr = maxStr + "," + val;
            }
            bucket[index]= maxStr;
        }


        int j =0;
        for(int i=maxLen; i>0; i--){
            if(j<k &&  bucket[i] != null) {
                List<String> tmp = Arrays.asList( bucket[i].split(",") );
                kthArr.addAll( tmp );
                j++;
            }
        }

        return kthArr;
    }


    public  static void  main(String [] args){

        List<String> arr = new ArrayList<>();

        arr.add("abc");
        arr.add("ghi");
        arr.add("ghi");
        arr.add("abc");
        arr.add("ghi");
        arr.add("abc");
        arr.add("wez");
        arr.add("ge");
        arr.add("ccc");
        arr.add("234r");
        arr.add("pp");
        arr.add("pp");

        List<String> kthArr = findKthStrings2(arr,2);

        for(String str: kthArr){
            System.out.println(str);
        }
    }
}
