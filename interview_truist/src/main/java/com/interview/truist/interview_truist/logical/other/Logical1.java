package com.interview.truist.interview_truist.logical.other;

import java.util.Iterator;
import java.util.Scanner;

public class Logical1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
//		checkEvenOdd(number);
		
//		writeFactorial(number);
		
		checkPrime(number);
		
	}

	private static void checkPrime(int number)
	{
		int count = 0;
		
		
		for (int i = 0; i < number; i++) {
			if (number % i == 0) {
				count++;
			}

		}
		
		if (count == 2)
		{
			System.out.println("it is prime number");
		}
		
	}

	private static void writeFactorial(int number)
	{
		// TODO Auto-generated method stub
		
		int sum = 1;
		
		for(int i = 1; i <= number; i++)
		{
			sum = sum * i;
		}
		
		System.out.println("Factorial of no is : "+sum);
		
	}

	private static void checkEvenOdd(int number)
	{
		// TODO Auto-generated method stub
		
		if (number % 2 == 0)
		{
			System.out.println("even");
		}else {
			System.out.println("odd");
		}
		
	}

}
