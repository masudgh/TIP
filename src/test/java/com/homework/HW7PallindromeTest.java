package com.homework;

import com.homework.Recursive.HW7Pallindrome;
import org.junit.Test;

import static org.junit.Assert.*;

public class HW7PallindromeTest {
    HW7Pallindrome palindrom = new HW7Pallindrome();

    @Test
    public void isPalindrome() {
        assertTrue(palindrom.isPalindrome("racecar"));
        assertTrue(palindrom.isPalindrome("abba"));
        assertTrue(palindrom.isPalindrome("a"));
        assertFalse(palindrom.isPalindrome("hello"));
        assertFalse(palindrom.isPalindrome("ax"));

    }
}