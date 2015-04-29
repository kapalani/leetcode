import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedSubstrings {
	public static void main (String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> result = findRepeatedDnaSequences(s);
		for (String str:result)
			System.out.println(str);
	}
	
	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> list = new ArrayList<String>();
	 
		if (s == null || s.trim().isEmpty() || s.length() < 10 ) return list;
	 
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
	 
		Set<Integer> temp = new HashSet<Integer>();
		Set<Integer> alreadyAdded = new HashSet<Integer>();
		int hash = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i < 9) {
				//each ACGT fit 2 bits, so left shift 2
				hash = (hash << 2) + map.get(s.charAt(i)); 
			} else {
				hash = (hash << 2) + map.get(s.charAt(i));
				//make length of hash to be 20
				hash = hash & (1 << 20) - 1; 
	 
				if (temp.contains(hash) && !alreadyAdded.contains(hash)) {
					list.add(s.substring(i - 9, i + 1));
					alreadyAdded.add(hash);
				} else {
					temp.add(hash);
				}
			}
	 
		}
	 
		return list;
	}
}
