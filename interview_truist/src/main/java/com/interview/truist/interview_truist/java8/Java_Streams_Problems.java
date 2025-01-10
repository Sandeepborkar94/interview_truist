package com.interview.truist.interview_truist.java8;

import java.util.Arrays;
import java.util.List;

public class Java_Streams_Problems {
//	Problem: Filter prime numbers from a list

	/*
	 * public static void main(String[] args) { List<Integer> numbers =
	 * Arrays.asList(10, 15, 17, 19, 23, 24);
	 * 
	 * List<Integer> primeNo
	 * =numbers.stream().filter(StreamExamples::isPrime).collect(Collectors.toList()
	 * );
	 * 
	 * System.out.println(primeNo);
	 * 
	 * }
	 * 
	 * public static boolean isPrime(int num) { if (num <= 1) return false; for (int
	 * i = 2; i <= Math.sqrt(num); i++) { if (num % i == 0) return false; } return
	 * true; }
	 * 
	 */

	public static void main(String[] args) 
	{
		/*
		List<String> names = Arrays.asList("apple", "banana", "apricot", "blueberry");
		
		Map<Character, List<String>> groupedBy = names.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
		
		System.out.println(groupedBy);
		
		
		*/
		
		
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
		
//		String collect = names.stream().collect(Collectors.groupingBy(s -> s.charA)
//				
//		Map<Character, List<String>> groupedByFirstChar = names.stream()
//                .collect(Collectors.groupingBy(s -> s.charAt(0));
		
		List<Integer>  integers = Arrays.asList(1,3,4,5,6,7777,8,5,3,33,5,7,4,33,55,334);
		
		int maxNo = integers.stream().max(Integer::compareTo).orElseThrow();
		
		System.out.println(maxNo);

		
	}

}
