package leetcode;

import java.util.ArrayList;
import java.util.List;

// given a lowercase string 'ab',write a program to generate all possible 
//lowercase and uppercase combination {'AB',‘Ab’,'aB' and 'ab'} 
public class LetterCombinations {
	public static void main (String[] args) {
		List<String> result = getCombinations("abc");
		for (String s : result) {
			System.out.println(s);
		}
	}
	
	private static List<String> getCombinations (String s) {
		List<String> result = new ArrayList<String>();
		if (s == null) return result;
		helper("", s, s.length(), result);
		return result;
	}
	
	private static void helper (String prefix, String suffix, int len, List<String> result) {
		if (suffix.length() == 0 && prefix.length() == len)
			result.add(prefix);
		else {
			for (int i = 0; i < suffix.length(); i++) {
				helper(prefix + suffix.charAt(i), suffix.substring(i+1), len, result);
				helper(prefix + suffix.toUpperCase().charAt(i), suffix.substring(i+1), len, result);
			}
		}
	}
}
