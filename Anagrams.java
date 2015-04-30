import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
	public static void main(String[] args) {
		String[] str = {"acbe", "ebca", "dfgf", "ffgd", "ttss"};
		List<String> result = anagrams(str);
		for (String s:result) {
			System.out.print(s+" ");
		}
	}

	public static List<String> anagrams(String[] strs) {
		List<String> result = new ArrayList<String>();
        if (strs==null) return result;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i=0; i<strs.length; i++) {
        	char[] c = strs[i].toCharArray();
        	Arrays.sort(c);
        	String sorted = new String(c);
        	if (!map.containsKey(sorted)) {
        		map.put(sorted, i);
        	} else {
        		if (map.get(sorted) != -1) {
        			result.add(strs[map.get(sorted)]);
        			map.put(sorted, -1);
        		}
        		result.add(strs[i]);
        	}
        }
        return result;
    }
}
