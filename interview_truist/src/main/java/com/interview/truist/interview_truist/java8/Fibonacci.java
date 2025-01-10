package com.interview.truist.interview_truist.java8;

public class Fibonacci 
{
	public static void main(String[] args) 
	{
		System.out.println("1, ");
		
		int j = 1, k = 0;
		
		for(int i = 0; i <=9; i++)
		{
			int m = j + k;
			
			System.out.println(m + ",");
			
			k = j;
			j = m;
		}
		
	}

}
