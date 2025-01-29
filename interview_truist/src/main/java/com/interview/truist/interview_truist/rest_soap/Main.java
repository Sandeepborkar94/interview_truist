package com.interview.truist.interview_truist.rest_soap;

import java.util.Arrays;
import java.util.List;

public class Main 
{
	public static void main(String[] args) {
		List<Student> studentsList = Arrays.asList(new Student(1, "sandeep", "miet"), new Student(1, "sandeep", "miet"),
				new Student(1, "sandeep", "miet"));

		studentsList.stream().filter(s -> s.getName().startsWith("s")).map(Student::getName).forEach(System.out::println);

	}

}
