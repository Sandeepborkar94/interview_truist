package com.interview.truist.interview_truist.suntrust;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student
{
	private int id;
	private String name;

	public Student()
	{
		super();
	}

	public Student(int id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString() 
	{
		return "Student [id=" + id + ", name=" + name + "]";
	}

}

public class Client {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student(1, "abc"),
												new Student(2, "xyz"), 
												new Student(3, "bbb"));

//		for (Student student2 : students)
//		{
//			String name = student2.getName();
			
//			if (name.startsWith("b")) 
//			{
//				System.out.println(name);
//			}
			
			
//		}

		List<Student> filteredStudent = students.stream().filter( student -> student.getName()
				.toLowerCase()
				.startsWith("b")).collect(Collectors.toList());
		
		filteredStudent.forEach(System.out::println);
		
	}

}
