package com.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class HW13PalindromicDecompTest {
    HW13PalindromicDecomp decompose =new HW13PalindromicDecomp();

    @Test
    public void isPalindrome() {
    }

    @Test
    public void printPalindrom() {
         decompose.printPalindrom("ada");
         System.out.println("---------");
         decompose.printPalindrom("abracadabra");
         System.out.println("---------");
         decompose.printPalindrom("geeks");

    }
}