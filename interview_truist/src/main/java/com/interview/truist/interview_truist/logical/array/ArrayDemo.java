package com.interview.truist.interview_truist.logical.array;

import java.util.Arrays;
import java.util.List;

public class ArrayDemo 
{
	public static void main(String[] args)
	{
		DVD[] arrayOfDVS = new DVD[4];

		arrayOfDVS[0] = new DVD("Movie One", 2001, "Director One");
		arrayOfDVS[1] = new DVD("Movie Two", 2002, "Director Two");
		arrayOfDVS[2] = new DVD("Movie Three", 2003, "Director Three");
		arrayOfDVS[3] = new DVD("Movie Four", 2004, "Director Four");

		for (int i = 0; i < arrayOfDVS.length; i++) 
		{
//			System.out.println(arrayOfDVS[i]);
//			System.out.println(arrayOfDVS[i].getName());
		}

		System.out.println("-------------------------------");

		List<DVD> listOfDvds = Arrays.asList(new DVD("Movie One", 2001, "Director One"),
				new DVD("Movie Two", 2002, "Director Two"), new DVD("Movie Three", 2003, "Director Three"),
				new DVD("Movie Four", 2004, "Director Four"));

		
		 // Print only the movie names using a traditional for loop
        for (int i = 0; i < listOfDvds.size(); i++) 
        {
            System.out.println(listOfDvds.get(i).getReleaseYear());
        }
		
//		for (DVD dvd : listOfDvds)
//		{
//			System.out.println(dvd.getReleaseYear());
//		}

//		System.out.println(listOfDvds);

	}

}
