package com.interview.truist.interview_truist.logical;

import java.util.HashMap;
import java.util.Map;

public class TwoSumOneMore
{
	public static void main(String[] args) 
	{
		TwoSumOneMore twoSumOneMore = new TwoSumOneMore();
		
		int[] nums = { 1, 2, 3, 4, 5 };

		int target = 5;

		int[] result = twoSumOneMore.twoSum(nums, target);

		System.out.println(result[0] + " " + result[1]);
		
	}

	private int[] twoSum(int[] nums, int target) 
	{
		Map<Integer, Integer>  map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++)
		{
			int cur = nums[i];
			
			int x = target - cur;
			
			if (map.containsKey(x))
			{
				return new int [] {map.get(x), i};
			}
			
			map.put(nums[i], i);
			
		}
		
		
		return null;
	}

}
