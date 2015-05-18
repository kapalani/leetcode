package leetcode;

//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...

//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.

//Note: The sequence of integers will be represented as a string.
public class CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(1122));
		System.out.println(countAndSaySequence(4));
	}
	
	public static String countAndSay(int n) {
        if (n <= 0) return null;
        
       String s = Integer.toString(n);
       
       int i = 0;
       char current = s.charAt(i);
       int ct = 1;
       i++;
       StringBuilder builder = new StringBuilder();
       while (i < s.length()) {
    	   if (s.charAt(i) == current) {
    		   ct++;
    	   } else {
    		   builder.append(ct);
    		   builder.append(s.charAt(i-1));
    		   ct = 1;
    		   current = s.charAt(i);
    	   }
    	   i = i + 1;
       }
       
       builder.append(ct);
	   builder.append(s.charAt(i-1));
        
	   return builder.toString();
    }
	
	public static String countAndSaySequence(int n) {
		if (n <= 0) return null;
		
		int i = 1;
		String result = "1";
		
		while (i < n) {
			StringBuilder builder = new StringBuilder();
			int ct = 1;
			
			for (int j = 1; j < result.length(); j++)
				if (result.charAt(j) == result.charAt(j - 1)) {
					ct++;
				} else {
					builder.append(ct);
					builder.append(result.charAt(j - 1));
					ct = 1;
				}
			builder.append(ct);
			builder.append(result.charAt(result.length() - 1));
			result = builder.toString();
			i++;
		}
		
		return result;
	}
	
}
