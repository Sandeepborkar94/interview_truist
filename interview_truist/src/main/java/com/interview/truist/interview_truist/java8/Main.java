package com.interview.truist.interview_truist.java8;

public class Main 
{
	public static void main(String[] args) 
	{
		MathOperation mathOperation = (a,b) -> a+b;
		
		System.out.println(mathOperation.operate(6, 8));
	}

}
