package com.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    private static int MAX_CHARS = 26;

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if( a == null || b == null) return false;
        if( a.isEmpty() || b.isEmpty()) return false;
        if( a.length() != b.length()) return false;

        int [] charSet = new int [MAX_CHARS];

        Arrays.fill(charSet,0);
        int n1 = a.length();

        String alow =a.toLowerCase();
        String blow = b.toLowerCase();
        for(int i=0; i< n1; i++){  // O(n)
            charSet[ alow.charAt(i)  - 'a']++;
        }

        int n2 = blow.length();
        for(int i=0; i< n2; i++){  // O(n)
            if(charSet[ blow.charAt(i)  - 'a'] >0)
                charSet[ blow.charAt(i)  - 'a']--;
        }

        int count =0;
        for(int i=0; i<MAX_CHARS; i++){
            count += charSet[i];
        }

        return count ==0;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
