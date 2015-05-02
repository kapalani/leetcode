
public class MinInSortedArray {
	public static void main(String[] args) {
		int[] nums = {5,1,2,3,4};
		int res = findMin(nums);
		System.out.println(res);
	}
	public static int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(start <= end) {
        	int mid = start + (end - start)/2;
        	if (nums[mid] < min) min = nums[mid];
        	if (nums[start] < nums[mid]) {
        		if (nums[end] < nums[start]) {
        			start = mid + 1;
        		} else {
        			end = mid - 1;
        		}
        	} else {
        		if (nums[end] > nums[start] || nums[mid] < nums[end]) {
        			end = mid - 1;
        		} else {
        			start = mid + 1;
        		}
        	}
        }
        
        return min;
    }
}
