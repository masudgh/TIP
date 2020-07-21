package com.homework;

public class HW15ExpressionCreator {
    /*
    Given a string of integers as input, put between each pair of digits,
    one of {“”, “*”, “+”}  and print the output

eg.
input: "123"
output:
"123"
"12*3"
"12+3"
"1*2*3"
"1*2+3"
"1+2+3"
"1*23"
"1+23"
"1+2*3"
     */


    public void printExpression(String str){
        if(str ==null) return;
        if(str.isEmpty()) return;

        if(str.length() ==1) {
            System.out.println(str);
        }

        char [] result = new char [str.length()*2-1];

        result[0] = str.charAt(0);
        printExpression(str, 1, result, 1);
    }


    private void printExpression( String str, int index, char [] result, int j ){

        int n = str.length();
        if(index >= n) {
              for(int i=0; i<j; i++){
                  System.out.print(result[i]);
              }
              System.out.println();
            return;
        }

        result[j] = str.charAt(index); //Either do not put the special character
        printExpression(  str, index+1, result ,j+1);

        result[j] = '*'; //or put the special character
        result[j+1] = str.charAt(index); // followed by the next character in the string

        printExpression(  str, index+1, result ,j+2);


        result[j] = '+'; //or put the special character
        result[j+1] = str.charAt(index); // followed by the next character in the string

        printExpression(  str, index+1, result ,j+2);

    }


}
