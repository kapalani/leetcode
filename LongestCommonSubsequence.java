
public class LongestCommonSubsequence {
	public static void main (String[] args) {
		String result = lcs("XXYT", "AXYT");
		System.out.println(result);
	}
	
	private static String lcs(String s, String t) {
		if (s == null || t == null)
			return null;
		int[][] temp = new int[s.length()+1][t.length()+1];
		
		int startIndex = -1;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if (i == 0 || j == 0)
					temp[i][j] = 0;
				else if (s.charAt(i-1) == t.charAt(j-1)) {
					if (startIndex == -1) {
						startIndex = i-1;
					}
					temp[i][j] = temp[i-1][j-1] + 1;
				}
					
				else 
					temp[i][j] = Math.max(temp[i][j-1], temp[i-1][j]);
			}
		}
		
		StringBuilder str = new StringBuilder();
		
		int i = s.length();
		int j = t.length();
		while (i > 0 && j > 0) {
			if (s.charAt(i-1) == t.charAt(j-1)) {
				str.append(s.charAt(i-1));
				i--;
				j--;
			} else if (temp[i][j-1] > temp[i-1][j]) {
				i--;
			} else {
				j--;
			}
		}
		
		String res = str.reverse().toString();
		return res;
	}
}
