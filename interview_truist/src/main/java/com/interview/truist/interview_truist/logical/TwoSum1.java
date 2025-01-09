package com.interview.truist.interview_truist.logical;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
	public static void main(String[] args) {
		TwoSum1 twoSum = new TwoSum1();

		int[] nums = { 1, 2, 3, 4, 5 };

		int target = 3;

		int[] result = twoSum.twoSum(nums, target);

		System.out.println(result[0] + " " + result[1]);

	}

	private int[] twoSum(int[] nums2, int target2) 
	{
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums2.length; i++) 
		{
			int cur = target2 - nums2[i];
			
			if (map.containsKey(cur))
			{
				return new int[] {map.get(cur), i};
			}
			
			map.put(nums2[i], i);
			
		}
		
		
		return null;
	}
}
