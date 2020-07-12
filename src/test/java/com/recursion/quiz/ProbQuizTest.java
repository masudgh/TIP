package com.recursion.quiz;

import com.recursion.Quiz.ProbQuiz1;
import org.junit.Test;

public class ProbQuizTest {
    ProbQuiz1 q = new ProbQuiz1();

    @Test
    public void isPalindrome() {
        boolean flag = q.isPalindrome("hello");
        System.out.println(flag);
    }
}