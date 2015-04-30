
public class IsomorphicStrings {
	public static void main(String[] args) {
		String s = "bb";
		String t = "aa";
		System.out.println(isIsomorphic(s, t));
	}
	
	public static boolean isIsomorphic(String s, String t) {
        if (s==null || t==null) return false;
        if(s.length() != t.length()) return false;
        
        char[] straightMap = new char[256];
        char[] reverseMap = new char[256];
        
        int len = s.length();
        for (int i=0; i<len; i++) {
        	int k = (int)s.charAt(i);
        	int h = (int)t.charAt(i);
        	if (straightMap[k] == 0 && reverseMap[h] == 0) {
        		straightMap[k] = t.charAt(i);
        		reverseMap[h] = s.charAt(i);
        	} else if (straightMap[k] != t.charAt(i) || reverseMap[h] != s.charAt(i)) {
        		return false;
        	}
        }
        return true;  
     }
}
