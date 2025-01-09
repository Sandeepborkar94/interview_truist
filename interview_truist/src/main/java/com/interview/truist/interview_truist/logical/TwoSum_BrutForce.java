package com.interview.truist.interview_truist.logical;

public class TwoSum_BrutForce
{
	public static void main(String[] args) 
	{
		TwoSum_BrutForce twoSum = new TwoSum_BrutForce();
		
		int[] nums = {1,2,3,4,5};
		
		int target = 3;
		
		int[] result = twoSum.twoSum(nums, target);
		
		System.out.println(result[0]+" "+result[1]);
		
	}

	private int[] twoSum(int[] nums, int target) 
	{
		for (int i = 0; i < nums.length; i++) 
		{
			for (int j = i+1; j < nums.length; j++) 
			{
				if (nums[i] + nums[j] == target) 
				{
					return new int[] {i , j};
				}
			}
			
		}
		return null;
		
	}
	
	

}
