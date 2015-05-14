package leetcode;


public class MaximumSubarray {

	public static void main (String[] args) {
		int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(max_subarray(array));
	}

	private static int max_subarray(int[] nums) {
		if (nums.length == 0) return 0;
		
		int max_ending_here = nums[0];
		int max_so_far = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max_ending_here = Math.max(nums[i], max_ending_here + nums[i]);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		
		return max_so_far;
		
	}
}
