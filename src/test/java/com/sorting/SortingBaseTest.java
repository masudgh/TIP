package com.sorting;

public class SortingBaseTest {

    public int [] arrSmall  = {100,80,80,30,25,40,50,70};
    public int [] arrLarge = {3, 76, 83, 54, 81, 63, 80, 56, 59, 16, 25, 10, 1, 92, 9, 8, 36, 96, 62, 50, 64, 2, 65, 69, 68};





    public void printArr(String str, boolean isSmallArr){
        System.out.println(str);

        if(isSmallArr) {
            for (int tmp : arrSmall)
                System.out.print(tmp + " ");
        }else{
            for (int tmp : arrLarge)
                System.out.print(tmp + " ");
        }
        System.out.println();
    }


    public void printArr(String str, int[] num){
        System.out.println(str);
        for (int tmp : num)
            System.out.print(tmp + " ");
        System.out.println();
    }


}
