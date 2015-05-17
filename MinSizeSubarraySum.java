package leetcode;

//Given an array of n positive integers and a positive integer s, find the minimal length of a 
//subarray of which the sum ≥ s. If there isn't one, return 0 instead.

//For example, given the array [2,3,1,2,4,3] and s = 7,
//the subarray [4,3] has the minimal length under the problem constraint.
public class MinSizeSubarraySum {
	public static void main(String[] args) {
		int[] nums = {1, 4, 4};
		System.out.println(minSubArrayLen(4, nums));
	}
	
	public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
        	return 0;
        }
        
        int sum_so_far = 0;
        int min_so_far = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while (end < nums.length) {
        	while(sum_so_far < s && end < nums.length)
        		sum_so_far += nums[end++];
        	while (sum_so_far >= s && start < nums.length) {
        		min_so_far = Math.min(end - start, min_so_far);
        		sum_so_far -= nums[start++];
        	}
        }
        
        return min_so_far==Integer.MAX_VALUE? 0: min_so_far;
    }
}
