package com.interview.truist.interview_truist.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java_Streams_Practice {
	public static void main(String[] args) {
		/*
		 * Intermediate Operations: Transform a stream into another stream. Examples:
		 * filter(), map(), sorted(), distinct(), flatMap(). Lazily evaluated.
		 * 
		 * 
		 * Terminal Operations: Produce a result or a side effect. Examples: collect(),
		 * forEach(), reduce(), count(), anyMatch(). Trigger execution of intermediate
		 * operations.
		 * 
		 * Short-Circuiting Operations: Terminate the stream processing early. Examples:
		 * findFirst(), findAny(), limit(), anyMatch().
		 * 
		 * 
		 * 1. filter(Predicate) -> Filters elements based on a condition.
		 * 
		 * 2 map(Function) -> Transforms each element in the stream.
		 * 
		 * 
		 * List<String> string = Arrays.asList("aaa","bbb","ccc");
		 * 
		 * List<String> upper =
		 * string.stream().map(String::toUpperCase).collect(Collectors.toList());
		 * 
		 * System.out.println(upper);	
		 * 
		 * string.stream().map(String::toLowerCase).forEach(System.out::println);
		 * 
		 * 3. flatMap(Function) -> Flattens nested structures into a single stream.
		 * 
		 * List<List<Integer>> nestedList =
		 * Arrays.asList(Arrays.asList(1,2,3,3,3,3,3,3,4,5), Arrays.asList(7,8,9,8,20));
		 * 
		 * List<Integer> flattenStream =
		 * nestedList.stream().flatMap(List::stream).distinct().collect(Collectors.
		 * toList());
		 * 
		 * 
		 * 
		 * distinct() -> Removes duplicate elements.
		 * 
		 */

		List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2, 3, 3, 3, 3, 3, 3, 4, 5),
				Arrays.asList(7, 4, 3, 2, 6, 8, 9, 8, 20));

		List<Integer> flattenStream = nestedList.stream().flatMap(List::stream).distinct().sorted()
				.collect(Collectors.toList());

		System.out.println("flattenStream : "+flattenStream);
		
		Integer reducedStream = flattenStream.stream().reduce(0, Integer::sum);
		
		long count = flattenStream.stream().count();
		
		System.out.println("reducedStream: "+reducedStream+" "+"COUNT IS : "+count);
	}

}
