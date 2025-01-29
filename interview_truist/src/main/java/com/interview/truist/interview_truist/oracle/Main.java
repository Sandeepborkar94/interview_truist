package com.interview.truist.interview_truist.oracle;

public class Main implements  MyFunctionalInterface
{
    public static void main(String[] args)
    {
//        MyFunctionalInterface anInterface = (x, y) -> x*y ;

//        MyFunctionalInterface anInterface = (x, y) ->  x * y;

//        System.out.println(anInterface.m2(10,5));

        Main main = new Main();
         int result =main.m2(10,5);

        System.out.println(result);
    }

    @Override
    public int m2(int a, int b)
    {
        return a*b;
    }


}
