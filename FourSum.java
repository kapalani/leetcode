import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FourSum {
	
	public static void main(String[] args) {
		int[] S = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> result = fourSum(S, 0);
		for (List<Integer> l: result) {
			for (Integer i: l) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	}

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<List<Integer>>();
        for (int i=0; i<nums.length; i++) {
        	for (int j=i+1; j<nums.length; j++) {
        		int start = j+1;
        		int end = nums.length-1;
        		while (start >= 0 && start < end) {
        			int sum = nums[i] + nums[j] + nums[start] + nums[end];
        			if (sum == target) {
        				List<Integer> temp = new ArrayList<Integer>();
        				temp.add(nums[i]);
        				temp.add(nums[j]);
        				temp.add(nums[start]);
        				temp.add(nums[end]);
        				list.add(temp);
        				start++;
        				end--;
        			} else if (sum > target) {
        				end--;
        			} else {
        				start++;
        			}
        		}
        	}
        }
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        l.addAll(list);
        return l;
    }
}
