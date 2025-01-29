package com.interview.truist.interview_truist.logical;

public class ArrayDemo
{
	public static void main(String[] args) 
	{
		int[] arr = new int[5];
		
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[4] = 4;
		arr[3] = 3;
		
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println("Numbers in arrays using for loop : "+arr[i]);
		}
		
		System.out.println("------------------------------------");
		
		for (int i : arr) 
		{
			System.out.println("Numbers in arrays using for each : "+i);
		}
	}

}
