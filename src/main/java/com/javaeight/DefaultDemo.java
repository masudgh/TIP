package com.javaeight;

public interface DefaultDemo {
    public void change();

    default void changeDefault(){
        System.out.println("Some default method");
    }


}
