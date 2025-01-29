package com.interview.truist.interview_truist.logical.oracle;

public class DemoInterfaceImpl
							implements DemoInterface
{

	@Override
	public String m1(String s) 
	{
		return s.toLowerCase();
	}
	
	
	public static void main(String[] args) 
	{
		DemoInterface demoInterface = new DemoInterfaceImpl();
		
		String ss = demoInterface.m1("SANDEEP");
		
		System.out.println(ss);
	}


	@Override
	public String m2() {
		// TODO Auto-generated method stub
		return null;
	}

}
