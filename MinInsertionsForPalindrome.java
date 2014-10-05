public class MinInsertionsForPalindrome {
	public static void main(String[] args){
		String s = "abcda";
		int result = dynamic(s);
		System.out.println(result);
	}
	
	public static int findMinInsertions(String s, int l, int r){
		if(l==r)
			return 0;
		if(l==r-1)
			return s.charAt(l)==s.charAt(r) ? 0 : 1;
		if(s.charAt(l)==s.charAt(r))
			return findMinInsertions(s, l+1, r-1);
		else
			return (Math.min(findMinInsertions(s, l, r-1), findMinInsertions(s, l+1, r)))+1;
	}
	
	public static int dynamic(String s){
		if(s==null)
			return 0;
		if(s.length()==1)
			return 0;
		int n = s.length();
		int[][] tmp = new int[n][n];
		for(int gap=1;gap<n;gap++){
			for(int l=0, r=gap; r<n;l++, r++){
				tmp[l][r] = s.charAt(l)==s.charAt(r) ? tmp[l+1][r-1] : ((Math.min(tmp[l+1][r], tmp[l][r-1])) + 1);
			}
		}
		
		return tmp[0][n-1];
	}
}
