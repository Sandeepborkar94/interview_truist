package com.interview.truist.interview_truist.java8;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8_Practice {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(2, 4, 6, 7, 8, 9, 10, 56);
//		
//		nums.sort((s1, s2 ) -> s2.compareTo(s1));
//		
//		System.out.println(nums);

		List<Integer> collect = nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

		nums.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

		System.out.println("-------**--------**----------**--------**---------**---------**----------");

		nums.stream().filter(n -> n % 2 == 0).map(n -> n * n).forEach(System.out::println);

		System.out.println(nums);

		System.out.println(collect);

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		
		LocalDate date1 = LocalDate.of(2024, 1, 1);
		
		System.out.println(date1);
		
		LocalDate date2 = LocalDate.of(2024, 1, 15);
		long daysBetween = ChronoUnit.DAYS.between(date1, date2);
		System.out.println(daysBetween);
		
		//
		Map<String, List<String>> gruopeD = Stream.of("apple","banana","avacode").collect(Collectors.groupingBy(s -> s.substring(0,1)));
		
		System.out.println(gruopeD);

	}

}