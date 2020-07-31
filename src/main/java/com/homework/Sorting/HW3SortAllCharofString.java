package com.homework.Sorting;

public class HW3SortAllCharofString {

    /*
    Sort an array of characters (ASCII only, not UTF8).
Input: A string of characters, like a full English sentence, delimited by a newline or NULL.
Duplicates are okay.
Output: A string of characters, in sorted order of their ASCII values. You can overwrite the
existing array.
Solution Complexity: Aim for linear time and constant additional space.
(What to understand from this problem: ASCII is great, because it's limited to 256. Remember
that for any input that is bound to a range)
Interview time: 15 minutes.
     */

    private static void sortCharinStr(String str){

        char [] ascii = new char [256];  //Constant space
        char [] arr = str.toCharArray();

        for(int i=0; i< arr.length; i++){  //O(n)

            ascii[arr[i]]++;
        }

        System.out.print("Reversed String: ");
        for( int i=0; i<256; i++){
            if(ascii[i] >0) {
                char ch = (char) i;
                System.out.print(ch);
            }
        }
    }


    public static void main(String [] args){

        String str = "Tom is Happy";
        System.out.println("Original String: " + str);
        sortCharinStr(str);
    }
}
