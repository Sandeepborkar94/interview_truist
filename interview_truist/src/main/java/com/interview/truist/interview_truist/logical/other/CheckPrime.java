package com.interview.truist.interview_truist.logical.other;

public class CheckPrime 
{
	public static void main(String[] args) 
	{
		int num = 1;
		
		int count = 0;
		
		for (int i = 0; i <= num; i++)
		{
			if (num % 2 == 0)
			{
				count++;
			}
			
		}
		
		if (count == 2)
		{
			System.out.println("prime");
		}else {
			System.out.println("Not prime");
		}
		
	}

}
