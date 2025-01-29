package com.interview.truist.interview_truist.oracle;

public interface MyFunctionalInterface1
{
    void m1();

    // default method implementation
    default void defaultMethod(){
        System.out.println("this is default implementation from MyFunctionalInterface1");
    }

    //static method
    static void staticMethod(){
        System.out.println("this is static method in the interface from MyFunctionalInterface1");
    }
}
