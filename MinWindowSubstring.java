import java.util.HashMap;
import java.util.Map;


public class MinWindowSubstring {
	public static void main(String[] args) {
		String s = "AA";
		String t = "AA";
		System.out.println(minWindow(s, t));
			
	}
	
	public static String minWindow(String s, String t) {
        if (s==null || t==null) return null;
        
        Map<Character, Integer> inputMap = new HashMap<Character, Integer>();
        for (int i=0;i<t.length();i++) {
        	char c = t.charAt(i);
        	if (inputMap.containsKey(c)) {
        		inputMap.put(c, inputMap.get(c)+1);
        	} else {
        		inputMap.put(c, 1);
        	}
        }
        
        Map<Character, Integer> currentMap = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        int found = 0;
        String minString = "";
        int min = Integer.MAX_VALUE;
        while(end < s.length()) {
        	char a = s.charAt(end);
        	if (inputMap.containsKey(a)) {
        		if (!currentMap.containsKey(a)) {
        			currentMap.put(a, 1);
        			found++;
        		} else {
        			if (currentMap.get(a) < inputMap.get(a)) {
        				found++;
        			}
        			currentMap.put(a, currentMap.get(a)+1);	
        		}
        	}
        	
        	if (found == t.length()) {
        		char b = s.charAt(start);
        		while(!currentMap.containsKey(b) || currentMap.get(b) > inputMap.get(b)) {
        			if (currentMap.containsKey(b) && currentMap.get(b) > inputMap.get(b)) {
        				currentMap.put(b, currentMap.get(b)-1);
        			}
        			start++;
        			b = s.charAt(start);
        		}
        		
        		if (end - start + 1 < min) {
        			minString = s.substring(start, end+1);
        			min = end - start + 1;
        		}
        	}
        	end++;
        }
        
        return minString;
    }
}
