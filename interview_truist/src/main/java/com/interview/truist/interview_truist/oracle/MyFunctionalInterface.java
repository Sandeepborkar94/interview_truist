package com.interview.truist.interview_truist.oracle;

@FunctionalInterface
public interface MyFunctionalInterface
{
//    void m1();

    int m2(int a , int b);

    // default method implementation
    default void defaultMethod(){
        System.out.println("this is default implementation");
    }

    default void defaultMethod1(){
        System.out.println("this is default1 implementation");
    }

    static void staticMethod1(){
        System.out.println("this is static method in the interface");
    }

    //static method
    static void staticMethod(){
        System.out.println("this is static method in the interface");
    }
}
