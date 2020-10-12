package com.homework.array;


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
