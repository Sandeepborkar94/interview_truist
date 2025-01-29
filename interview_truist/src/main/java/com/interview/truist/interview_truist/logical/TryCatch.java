package com.interview.truist.interview_truist.logical;

public class TryCatch 
{
	public static void main(String[] args)
	{
		System.out.println(checkArithMatic(5));
		
	}

	private static int checkArithMatic(int i)
	{
		try 
		{
			int j = i/0;
			return i;
			
		} catch (Exception e) 
		{
			// TODO: handle exception
		}
		return i;
		
	}

}
