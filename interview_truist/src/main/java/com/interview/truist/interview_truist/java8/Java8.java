package com.interview.truist.interview_truist.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 
{
	public static void main(String[] args) 
	{
//		 lambda expression to sort a list of strings in reverse alphabetical order.
		
		List<String> strings = Arrays.asList("abc","bce","cde","def"); //declaring a list
		
		strings.sort((s1,s2) -> s2.compareTo(s1)); 
		
		System.out.println(strings);
		
//		Explain the difference between map() and flatMap() in the Streams API.

//		map(): Transforms each element into another object. It keeps a one-to-one mapping.
//		flatMap(): Transforms each element into a stream and flattens the nested streams into a single stream.
		
		List<String> fruits = Arrays.asList("kivi","banana","mango","apple");
		
		System.out.println("List of fruits: "+fruits);
		
		List<Integer> collect = fruits.stream().map(s -> s.length()).collect(Collectors.toList());
		
		System.out.println("LIST GEN BY MAP : "+collect);
		
		List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		 // using flatmap() to flatten this list
//        List<Integer> flatList = number.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
       
        // printing the list
//        System.out.println("List generate by flatMap-"+ flatList);
		
//      filter is intermediate operation, it will not get the end result without terminal operation
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6).filter(n -> n % 2 == 0 );
		
		System.out.println(stream); // result in hashcode -> java.util.stream.ReferencePipeline$2@449b2d27
		
		stream.forEach(System.out::println); 
		// we will get result here with the help of forEach method which is terminal operation
		
		
		List<Integer> evenNo = number.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		
		System.out.println(evenNo);
		
		List<Integer> multiplNo = number.stream().filter(n -> n % 2 == 0).map(n -> n * 2).collect(Collectors.toList());
		
		System.out.println(multiplNo);
		
		List<Integer> oddNO = number.stream().filter(n -> n % 2 ==1 ).collect(Collectors.toList());
		
		System.out.println(oddNO);
		
		List<Integer> squreNo = number.stream().filter(n -> n % 2 == 1).map(n -> n * n).collect(Collectors.toList());
		
		System.out.println(squreNo);
	}

}
