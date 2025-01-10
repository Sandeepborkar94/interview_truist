package com.interview.truist.interview_truist.logical.other;

public class Palindrome1 
{
	public static void main(String[] args) 
	{
		int i = 121;
		
		int rev = 0, temp = i;
		
		while(i > 0) 
		{
			rev = rev * 10 + ( i % 10);
			
			i = i/10;
		}
		
		if (rev == temp) 
		{
			System.out.println("this is palindrome");
		}else {
			System.out.println("no no");
		}
	}

}
