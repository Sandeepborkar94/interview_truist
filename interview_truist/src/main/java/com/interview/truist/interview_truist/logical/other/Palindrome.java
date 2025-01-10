package com.interview.truist.interview_truist.logical.other;

public class Palindrome 
{
	public static void main(String[] args)
	{
		int number = 121;

		int rev = 0;

		int temp = number;

		while (number > 0)
		{
			rev = rev * 10 + (number % 10);

			number = number / 10;
		}
		
		if (temp == rev) 
		{
			System.out.println("palindrome");
		} else
		{
			System.out.println("not palindrome");
		}
	}

}
