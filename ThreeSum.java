import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ThreeSum {
	public static void main(String[] args) {
		int[] input = {-2, 0, 0, 2, 2};
		List<List<Integer>> result = threeSum(input);
		System.out.println(result);
	}
	
	public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (num.length < 3)
        	return list;
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(num);
        int n = num.length;
        int a, b, c, start, end;
        for (int i=0; i<n-2;i++) {
        	if (i == 0 ||num[i] > num[i-1]) {
        		a = num[i];
            	start = i+1;
            	end = n-1;
            	while (start < end) {
            		b = num[start];
            		c = num[end];
            		if (a+b+c == 0) {
            			set.add(createList(a, b, c));
            			start++;
            			end--;
            		} else if (a+b+c > 0) {
            			end--;
            		} else {
            			start++;
            		}
            	}
        	}
        }

        for (List l: set) {
        	list.add(l);
        }
        return list;
    }
	
	private static List<Integer> createList(int a, int b, int c) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(a);
		list.add(b);
		list.add(c);
		return list;
	}
}
