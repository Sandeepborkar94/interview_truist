package com.interview.truist.interview_truist.logical.array;

public class DVD 
{
	private String name;
	private int releaseYear;
	private String director;
	
	
	public DVD(String name, int releaseYear, String director) {
		super();
		this.name = name;
		this.releaseYear = releaseYear;
		this.director = director;
	}


	@Override
	public String toString()
	{
		return "DVD [name=" + name + ", releaseYear=" + releaseYear + ", director=" + director + "]";
	}


	public String getName() {
		return name;
	}


	public int getReleaseYear() {
		return releaseYear;
	}


	public String getDirector() {
		return director;
	}
	
	
	
	
}
