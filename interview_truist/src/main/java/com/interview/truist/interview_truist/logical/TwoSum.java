package com.interview.truist.interview_truist.logical;

import java.util.HashMap;

public class TwoSum
{
	public static void main(String[] args) 
	{
		TwoSum twoSum = new TwoSum();
		
		int[] nums = {1,2,3,4,5};
		
		int target = 5;
		
		int[] result = twoSum.twoSum(nums, target);
		
		System.out.println(result[0]+" "+result[1]);
		
		
	}
	
	 public int[] twoSum(int[] nums, int target)
	 {
	        HashMap<Integer, Integer> map = new HashMap<>();
	        
	        for (int i = 0; i < nums.length; i++)
	        {
	            int t = target - nums[i];
	            
	            if (map.containsKey(t))
	            {
	                return new int[] {map.get(t), i};
	            }
	            map.put(nums[i], i);
	        }
			return null;
	    }

}
