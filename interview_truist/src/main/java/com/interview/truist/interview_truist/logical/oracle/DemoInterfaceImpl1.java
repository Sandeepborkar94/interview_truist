package com.interview.truist.interview_truist.logical.oracle;

import java.util.Arrays;
import java.util.List;

public class DemoInterfaceImpl1 
{
	public static void main(String[] args)
	{
//		DemoInterface demoInterface = (s) -> s.toLowerCase();

//		System.out.println(demoInterface.m1("SANDEEP"));
		
		List<Integer> listNums = Arrays.asList(1,2,4,5,6,7,8);
		
		DemoInterface demoInterface = (x,y) -> x+y;
		
		
		
	}
	


}
