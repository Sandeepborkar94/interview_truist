package com.interview.truist.interview_truist.logical;

public class GetFactorial 
{
	public static void main(String[] args)
	{
		int x = 5;

		System.out.println(getFactorial(x));

	}

	private static int getFactorial(int x)
	{
		if (x == 0 || x == 1)
		{
			return 1;
		} else
		{
			int y = x * (getFactorial(x - 1));

			return y;
		}

	}

}
