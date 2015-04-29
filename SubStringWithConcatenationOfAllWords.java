import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubStringWithConcatenationOfAllWords {
	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
		findSubstring(s, words);
	}
	
	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
		if (s==null || words==null || words.length==0) return list;
		int len = words.length;
		int wordLen = words[0].length();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i=0; i<len; i++) {
			if (map.get(words[i]) != null) {
				map.put(words[i], map.get(words[i])+1);
			} else {
				map.put(words[i], 1);
			}
		}
		
		int inputStrLen = s.length();
		int totalLen = len * wordLen;
		for (int i=0; i<= inputStrLen - (totalLen); i++) {
			if (isValid(map, s, i, wordLen, totalLen)) {
				list.add(i);
			}
		}
		
		return list;   	
    }
	
	private static boolean isValid(Map<String, Integer> wordsMap,String s, int i, int wordLen, int totalLen) {
		 Map<String, Integer> tmpMap=new HashMap<String, Integer>(wordsMap);
	        
	        int start=i;
	        int end=i+wordLen;
	        
	        while(end-i<=totalLen){
	            String tmpString=s.substring(start, end);
	            if (tmpMap.containsKey(tmpString)){
	                if (tmpMap.get(tmpString)==0){
	                    return false;
	                }
	                tmpMap.put(tmpString, tmpMap.get(tmpString)-1);
	                start=end;
	                end=start+wordLen;
	            }
	            else{
	                return false;
	            }
	        }
	        return true;
	}
}
