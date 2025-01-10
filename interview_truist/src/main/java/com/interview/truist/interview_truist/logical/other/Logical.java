package com.interview.truist.interview_truist.logical.other;

import java.util.Scanner;

public class Logical {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("enter No : ");

		double number = scanner.nextDouble();
//		int number1 = scanner.nextInt();

		getPrime(number);

		double factorial = getFactorial(number);

		System.out.println("Factorial : " + factorial);

		getResult(factorial);

//		checkIfPalindrome(number1);
		
		/*
		 * even odd
		 * factorial
		 * prime 
		 * palindrome
		 * swapping
		 * */

		scanner.close();
	}

	private static void checkIfPalindrome(int number)
	{
		int temp = number;
		
		int rev = 0;


		while (number > 0)
		{
			rev = rev * 10 + (number % 10);

			number = number / 10;
		}

		if (temp == rev) 
		{
			System.out.println("palinedrome");
		} else
		{
			System.out.println("not palinderome");
		}

	}

	private static void getPrime(double number) {
		// TODO Auto-generated method stub
		int count = 0;

		for (int i = 0; i < number; i++) {
			if (number % i == 0) {
				count++;
			}

		}

		if (count == 2) {
			System.out.println("no is prime ");
		} else {
			System.out.println("not prime ");
		}

	}

	private static double getFactorial(double number) {
		double sum = 1;

		for (double i = 1; i <= number; i++) {
			sum = sum * i;
		}
		return sum;

	}

	public static void getResult(double number) {
		if (number % 2 == 0) {
			System.out.println("no is even even");
		} else {
			System.out.println(" no is odd");
		}
	}

}
