package com.homework.Sorting;

import java.util.ArrayList;
import java.util.List;

/*

Given two sorted arrays arr1 and arr2 of passport numbers, implement a function findDuplicates that returns an array of
 all passport numbers that are both in arr1 and arr2. Note that the output array should be sorted in an ascending order.

Let N and M be the lengths of arr1 and arr2, respectively.
Solve for two cases and analyze the time & space complexities of your solutions:
M ≈ N - the array lengths are approximately the same
and
M ≫ N - arr2 is much bigger than arr1.

Example:
input:  arr1 = [1, 2, 3, 5, 6, 7], arr2 = [3, 6, 7, 8, 20]

output: [3, 6, 7] # since only these three values are both in arr1 and arr2


 */
public class HW1FindDuplicates {


    public static List<Integer> findDuplicates1(int[] arr1, int [] arr2){

        //Use Merge Sort Algorithm


         // Find sizes of two subarrays to be merged
        int n1 = arr1.length;
        int n2 = arr2.length;


        List<Integer> dupArr =  new ArrayList<>();


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if(arr1[i] == arr2[j])
                    dupArr.add( arr1[i] );
                i++;

            }
            else {
                j++;
            }
            k++;
        }

        return dupArr;
    }

    public static List<Integer> findDuplicates2(int[] arr1, int [] arr2){

        List<Integer> dupArr =  new ArrayList<>();


        return null;
    }


    private static void printArr(List<Integer> duplicates){

        System.out.println("Duplicate Set");
        for(Integer i: duplicates){
            System.out.print(i+ ", ");
        }

        System.out.println();

    }


    public static long executor( long scale ){

        int [] arr1 = {1, 2, 3, 5, 6, 7};
        int [] arr2 = {3, 6, 7, 8, 20};


        List<Integer> duplicates1 = null;
        List<Integer> duplicates2 = null;
        long t1, t2, t3, t4;

        t1 = System.currentTimeMillis();
        for(long i=0;i<scale;i++) {
            duplicates1 = findDuplicates1(arr1, arr2);

        }

       // printArr(duplicates2);

        t2 = System.currentTimeMillis();

        int [] arr3 = {2, 11, 15, 29, 31, 49, 56, 91, 121, 160, 164, 166, 187, 201, 207, 222, 234, 260, 262, 268, 270,
                321, 336, 338, 361, 365, 367, 387, 406, 440, 452, 465, 470, 476, 477, 478, 486, 488, 504, 512, 514, 529,
                538, 544, 547, 551, 554, 560, 564, 573, 576, 584, 587, 600, 612, 616, 637, 643, 649, 652, 654, 660, 708,
                716, 734, 735, 738, 740, 747, 749, 750, 753, 765, 773, 801, 814, 815, 828, 835, 838, 879, 908, 926, 934,
                945, 958, 969, 973, 976, 1000};

        int [] arr4 = {551};

        t3 = System.currentTimeMillis();
        for(int i=0;i<scale; i++) {
            duplicates2 = findDuplicates1(arr3, arr4);
        }
        t4 = System.currentTimeMillis();


        //printArr(duplicates2);



        return ( (t4 - t3)- (t2 - t1));



    }

    public static void main(String [] args){


        System.out.println( " For same test scale factor the second case(m>n) takes longer time than first case (m~n): " );

        for(long i=1;i <100; i++) {
            System.out.println(" Test Scale Factor : Case [ m > n ] Time - Case [ m ~ n ] Time = " + i*999999999+ " : " + executor(i));
        }

    }


}
