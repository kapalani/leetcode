public class ValidPalindrome {
	public static void main(String[] args){
		boolean result = isPalindrome("!!!");
		System.out.println(result);
	}
	
	public static boolean isPalindrome(String str){
		if(str==null || str.trim().length()==0)
			return true;
		int p = 0;
		int q = str.length()-1;
		
		while( p<str.length() && !isAphaNumeric(str.charAt(p)))
			p++;
		
		while(q>=0 && !isAphaNumeric(str.charAt(q)))
			q--;
		
		if(p>q)
			return true;
		
		while(p<q){
			if(Character.toLowerCase(str.charAt(p))==Character.toLowerCase(str.charAt(q))){
				p++;
				q--;
				while(!isAphaNumeric(str.charAt(p)))
					p++;
				while(!isAphaNumeric(str.charAt(q)))
					q--;
			}else
				return false;
		}
		
		return true;
	}
	
	public static boolean isAphaNumeric(char x){
		if((x >= 'a' && x<= 'z') || x>= 'A' && x<='Z' || (x >= '0' && x <= '9'))
			return true;
		return false;
	}
}