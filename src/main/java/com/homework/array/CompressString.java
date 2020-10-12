package com.homework.array;

/*Simple version of the problem: Compress a string (only has alphabet characters), with
basic encoding, where you simply count the number of repeated characters. Then also write a
routine to decompress it.

e.g.
Input: "AAAAA"
Output: "5A"
Input: "BAAAB"
Output: "B3AB"
Input: "ABAB"
Output: "ABAB" [We are not concerned about characters repeating in groups]
Assume that a given character will not repeat more than 127 times.
Solution: Compression solution to this is very simple. It pretty much needs one loop.
Decompression is equally simple. Let us know if that is not clear.
Important twists to the problem:
* String can have any character from the basic ASCII set (ASCII values 0 to 127). i.e. it can now
include numbers.
* Compressed length must not exceed original length. It can be same or less.
Solution hint: Given that you cannot have numbers in your solution, can you use something
else? Can you make use of higher order ASCII values?
Test cases are given for compression of 2nd (twisted) case.


 */
import static java.lang.Character.isDigit;

public class CompressString {

    private static void deCompress(String str){

        if(str == null) return;
        int n = str.length();
        if(n==1) {
            System.out.println(str);
            return;
        }

        StringBuilder strBld = new StringBuilder();

        for(int i=0; i< n; i++){
            StringBuilder repeatCountStr = new StringBuilder();
            while( isDigit( str.charAt(i)) ){
                repeatCountStr.append(str.charAt(i++));
            }
            int repeatCount = 0;
            if(!repeatCountStr.toString().isEmpty()) {
                repeatCount = Integer.valueOf(repeatCountStr.toString());
            }

            if(repeatCount>1){
                for(int j=0; j< repeatCount && i<n ; j++) {
                    strBld.append(str.charAt(i));
                }
            }else {
                strBld.append(str.charAt(i));
            }
        }

        System.out.println( "De-Compressed :" + strBld.toString());
    }


    private static void compress(String str){
        if(str == null) return;
        int n = str.length();
        if(n==1) {
            System.out.println(str);
            return;
        }

        StringBuilder strBld = new StringBuilder();


        for(int i=0; i< n; i++){
            int repeatCount =1;
            while( i+1 <n && str.charAt(i)== str.charAt(i+1)  ){
                repeatCount++;
                i++;
            }
            if(repeatCount>1){
                strBld.append(repeatCount);
                strBld.append(str.charAt(i));
            }else {
                strBld.append(str.charAt(i));
            }
        }

        System.out.println( "Compressed :" + strBld.toString());
        deCompress(strBld.toString());
    }

    public static void main (String [] args){
        String[] str ={ "AAAAAAAAAAAAABAA", "BAAAB", "ABAB"};
        compress(str[0]);
        compress(str[1]);
        compress(str[2]);
    }
}
