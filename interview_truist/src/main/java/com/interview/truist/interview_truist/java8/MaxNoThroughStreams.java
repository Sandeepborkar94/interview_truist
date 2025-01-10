package com.interview.truist.interview_truist.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MaxNoThroughStreams {
	public static void main(String[] args) {
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * 
		 * // System.out.println("Enter an array list to find out greatest no");
		 * 
		 * // int nextInt = scanner.nextInt();
		 * 
		 * List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7);
		 * 
		 * Integer maxNo = nums.stream().filter(o -> o % 2 ==
		 * 0).max(Integer::compareTo).orElseThrow();
		 * 
		 * 
		 * // int sum = nums.stream().filter( n -> n % 2 !=
		 * 0).mapToInt(Integer::intValue).sum();
		 * 
		 * // int sum = numbers.stream().filter(n -> n % 2 !=
		 * 0).mapToInt(Integer::intValue).sum();
		 * 
		 * 
		 * int sumEven = nums.stream().filter(s -> s% 2 ==
		 * 0).mapToInt(Integer::intValue).sum();
		 * 
		 * IntStream mapToInt = nums.stream().filter(s -> s% 2 ==
		 * 0).mapToInt(Integer::intValue);
		 * 
		 * System.out.println(mapToInt);
		 * 
		 * System.out.println(mapToInt.sum());
		 * 
		 * System.out.println("sum of odd no "+sumEven);
		 * 
		 * // Optional<Integer> maxNo = nums.stream().filter(o -> o % 2 ==
		 * 0).max(Integer::compareTo);
		 * 
		 * System.out.println(maxNo);
		 * 
		 * List<Integer> numbers = Arrays.asList(2,3,4,5,6,7);
		 * 
		 * // numbers.stream().sorted().forEach(System.out::println);
		 * 
		 * List<Integer> revOrder =
		 * numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList(
		 * ));
		 * 
		 * System.out.println(revOrder);
		 * 
		 * Integer secondLargest =
		 * numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().
		 * orElseThrow(() -> new RuntimeException("List has few elements"));
		 * 
		 * System.out.println(secondLargest);
		 * 
		 * List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry",
		 * "avocado");
		 * 
		 * long count = words.stream().filter(s -> s.startsWith("a")).count();
		 * 
		 * System.out.println(count);
		 * 
		 * 
		 * List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry",
		 * "avocado");
		 * 
		 * words.stream().map(String::toUpperCase).forEach(System.out::println);
		 * 
		 * String ss = "swwiss";
		
		Optional<Character> findFreq = ss.chars()
				.mapToObj(c -> (char) c)
				.filter(ch -> ss.indexOf(ch) == ss.lastIndexOf(ch))
				.findFirst();

		System.out.println(findFreq.orElse(' '));
		
		 */
		
		 List<Integer> numbers = Arrays.asList(2,3,4,5,6,4,5,7);
		 
		 Set<Integer> uniqueSet = new HashSet<>();
		 
//		 numbers.stream().filter(n ->  !uniqueSet.add(n)).forEach(System.out::println);
		 
		 List<String> words = Arrays.asList("radar", "level", "world", "java", "civic");

		 words.stream().filter(word -> word.equals(new StringBuilder(word).reverse().toString())).collect(Collectors.toList());
		 
		
	}

}
