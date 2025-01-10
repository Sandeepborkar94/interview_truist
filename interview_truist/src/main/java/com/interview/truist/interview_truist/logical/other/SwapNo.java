package com.interview.truist.interview_truist.logical.other;

public class SwapNo {
	public static void main(String[] args) {
		int n1 = 15;
		int n2 = 24;

		System.out.println("before swap n1: " + n1);
		System.out.println("before swap n2:  " + n2);

//		int temp = n1;
//		n1 = n2;
//		n2 = temp;

		n1 = n1 + n2; // 15+24 = n1= 39;
		n2 = n1 - n2; // 39-24 = 15 n2
		n1 = n1 - n2; 

		System.out.println("after swap n1: " + n1);
		System.out.println("after swap n2: " + n2);
	}

}
