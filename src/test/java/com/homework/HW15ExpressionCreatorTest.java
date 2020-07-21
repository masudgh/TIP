package com.homework;

import org.junit.Test;

public class HW15ExpressionCreatorTest {

    HW15ExpressionCreator expr = new HW15ExpressionCreator();


    @Test
    public void printExpressionTest(){
        System.out.println("Expression for 123 : ");
        expr.printExpression("123");
        System.out.println("---------------------");
        System.out.println("Expression for 4539 : ");
        expr.printExpression("4539");
    }
}
