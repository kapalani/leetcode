import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MajorityElement {
	
	public static void main (String[] args) {
		int[] nums = {3, 3, 4};
		System.out.println(majorityElement(nums));
	}
	 
	public static int majorityElement(int[] nums) {
	        if (nums.length == 0) return -1;
	        
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int i=0; i < nums.length; i++) {
	        	if (map.containsKey(nums[i])) {
	        		map.put(nums[i], map.get(nums[i]) + 1);
	        	} else {
	        		map.put(nums[i], 1);
	        	}
	        }
	        
	        int n = nums.length/2;
	        int number = -1;
	        int currentN = 0;
	        Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
	        while (itr.hasNext()) {
	        	Map.Entry<Integer, Integer> entry = itr.next();
	        	if (entry.getValue() > currentN) {
	        		number = entry.getKey();
	        		currentN = entry.getValue();
	        	}
	        }
	        return number;
	}
}
