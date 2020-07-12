package com.homework;

public class HW4PowerSet {

    public void printSubset(int[] arr) {

        if (arr.length == 0) System.out.println(" {}");
        if (arr.length == 1) System.out.println(" {" + arr[0] + "}");

        int [] result = new int [0];
        findSubset(0, arr, result);
    }

    void findSubset(int curr, int[] arr, int [] result) {


        if (arr.length == curr) {
            System.out.print("{");
            for (int i : result)
                System.out.print(i + ",");
            System.out.println("}");
            return ;
        }

        int outNew[] = new int[result.length + 1];
        int k = 0;
        for (int i = 0; i < result.length; i++) {
            outNew[k] = result[i];
            k++;
        }

        outNew[k] = arr[curr];
        findSubset(curr + 1, arr, result);
        findSubset(curr + 1, arr,outNew);
    }

}


