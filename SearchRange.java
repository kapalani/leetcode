
public class SearchRange {
	public static void main(String[] args) {
		int[] nums1 = {5, 7, 7};
		int[] results = searchRange(nums1, 7);
		System.out.println(results[0] + " " + results[1]);
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] range = {-1, -1};
		if (nums.length == 0) return range;
		
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start)/2;
			if (nums[mid] == target) {
				int a = mid;
				int b = mid;
				while (a-1 >= start && nums[a-1] == target) {
					a--;
				}
				while (b+1 <= end && nums[b+1] == target) {
					b++;
				}
				range[0] = a;
				range[1] = b;
				return range;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return range;
	}
}
