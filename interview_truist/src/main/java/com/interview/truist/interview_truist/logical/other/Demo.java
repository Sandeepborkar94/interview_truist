package com.interview.truist.interview_truist.logical.other;

public class Demo
{
	public static void main(String[] args) 
	{
		int number = 8;

		int count = 0;

		for (int i = 1; i < number; i++)
		{
			if (number % i == 0)
			{
				count++;

			}
		}

		if (count == 2)
		{
			System.out.println("prime");
		} else
		{
			System.out.println("not prime");
		}

	}

}
