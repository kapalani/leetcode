import java.util.HashSet;
import java.util.Set;


public class WordBreak {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("leet");
		set.add("code");
		String s = "leetacode";
		System.out.println(wordBreakDynamic(s ,set));
	}
	
	public static boolean wordBreakRecursive(String str, Set<String> wordDict) {
		if (str.length() == 0) return true;
		
		for (int i=0; i<str.length(); i++) {
			if (wordDict.contains(str.substring(0, i)) && 
					wordBreakRecursive(str.substring(i, str.length()), wordDict)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean wordBreakDynamic(String str, Set<String> wordDict) {
		boolean[] arr = new boolean[str.length() + 1];
		arr[0] = true;
		
		for (int i=0; i<=str.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] && wordDict.contains(str.substring(j, i))){
					arr[i] = true;
				}
				if (arr[i])
					break;
			}
		}
		
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		return arr[str.length()];
	}
}
