public class EditDistance {
	public static void main(String[] args){
		int result = minDistance("teacher", "detacher");
		System.out.println(result);
	}
	
	public static int minDistance(String s, String p){
		if(s==null || p==null)
			return -1;
		int[][] tmp = new int[s.length()+1][p.length()+1];
		
		for(int i=0;i<=s.length();i++)
			tmp[i][0]=i;
		for(int j=0;j<=p.length();j++)
			tmp[0][j]=j;
		
		for(int i=1;i<=s.length();i++){
			char a = s.charAt(i-1);
			for(int j=1;j<=p.length();j++){
				char b = p.charAt(j-1);
				if(a==b)
					tmp[i][j] = tmp[i-1][j-1];
				else
					tmp[i][j] = min(tmp[i-1][j-1]+1, tmp[i-1][j]+1, tmp[i][j-1]+1);
			}
		}
		
		return tmp[s.length()][p.length()];
	}
	
	public static int min(int a, int b,int c){
		if(a <= b && a <= c)
			return a;
		else if(b <= c)
			return b;
		return c;
	}
}
