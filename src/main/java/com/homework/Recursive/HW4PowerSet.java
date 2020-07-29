package com.homework.Recursive;

/*
Give a set (array) of integers print all subsets(Powerset) of the set using Recursion. Create a
Recursion Tree to support your solution.
eg for given array: {1,2,3}
print:
{}
{1,2,3}
{1,2}
{1,3}
{3}
{2,3}
{2}
{1}
 */
public class HW4PowerSet {

    public void printSubset(int[] arr) {
        if (arr.length == 0) System.out.println(" {}");
        if (arr.length == 1) System.out.println(" {" + arr[0] + "}");
        printSubset(0, arr, new int [0]);
    }

    void printSubset(int curr, int[] arr, int [] result) {

        if (arr.length == curr) {
            System.out.print("{");

            for (int i =0; i<result.length; i++) {
                if (i < result.length - 1)
                    System.out.print(result[i] + ",");
                else
                    System.out.print(result[i] );
            }
            System.out.println("}");
            return ;
        }

        int modResult[] = new int[result.length + 1];
        int k = 0;
        for (int i = 0; i < result.length; i++) {
            modResult[k] = result[i];
            k++;
        }

        modResult[k] = arr[curr];
        printSubset(curr + 1, arr, result);
        printSubset(curr + 1, arr, modResult);
    }

}


