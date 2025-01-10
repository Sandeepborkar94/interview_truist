package com.interview.truist.interview_truist.logical;

public class CalculateSum {
	public static void main(String[] args) {
		String word = "2san765dep2";

		int calculate = calculate(word);

		System.out.println(calculate);

	}

	private static int calculate(String word) {
		String str1 = word;

		char[] c = str1.toCharArray();

		int sum = 0;

		for (int i = 0; i < c.length; i++) {
			if (Character.isDigit(c[i])) {
				System.out.println(c[i]);
				System.out.println();

				int a = Integer.parseInt(String.valueOf(c[i]));

				sum = sum + a;
			}
		}

		System.out.println("sum of digits : " + sum);
		return sum;

		// TODO Auto-generated method stub

	}

}
