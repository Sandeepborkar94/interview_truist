package com.interview.truist.interview_truist.logical.oracle;

public class Main 
{
	public static void main(String[] args) 
	{
		Calculator add =(a,b) -> a+b;
		Calculator sub =(a,b) -> a-b;
		Calculator mul =(a,b) -> a*b;
		Calculator div =(a,b) -> a/b;
		
		System.out.println(add.calculate(10, 10)+" : "+sub.calculate(20, 10)+" : "+mul.calculate(10, 5)+" : "+div.calculate(10, 2));
		
	}

}
