package leetcode;

//A peak element is an element that is greater than its neighbors.
//Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
//The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//You may imagine that num[-1] = num[n] = -∞.
//For example, in array [1, 2, 3, 1], 3 is a peak element and your function 
//should return the index number 2.

public class PeakElement {
	public static void main(String[] args){
		//int[] nums = {1, 2, 3, 1};
		int[] nums = {1, 2};
		System.out.println(findPeakElement(nums));
	}
	
	public static int findPeakElement(int[] nums) {
		
		if (nums.length == 0) return 0;
        int start = 0;
        int end = nums.length- 1;
        int mid = 0;
        
        while (start <= end) {
        	mid = start + (end - start)/2;
        	if ((mid == 0 || nums[mid] >= nums[mid-1]) && (mid == nums.length - 1 ||nums[mid] >= nums[mid + 1])) {
        		return mid;
        	}
        	else if (mid > 0 && nums[mid - 1] > nums[mid]) {
        		end = mid - 1;
        	} else {
        		start = mid + 1;
        	}
        }
        
        return mid;
    }
}
