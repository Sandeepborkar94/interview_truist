package com.interview.truist.interview_truist.rest_soap;

public class Student
{
	private int id;
	private String name;
	private String clgName;
	
	public Student(int id, String name, String clgName)
	{
		super();
		this.id = id;
		this.name = name;
		this.clgName = clgName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClgName() {
		return clgName;
	}

	public void setClgName(String clgName) {
		this.clgName = clgName;
	}
	
	
	
	
	
}
