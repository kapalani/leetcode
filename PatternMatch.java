public class PatternMatch {
	public static void main(String []args){
        boolean result = isMatch("aaaac", "a*c");
        System.out.println(result);
    }
    
    public static boolean isMatch(String s, String p) {
        
        if(s==null && p==null)
            return true;
        if(s==null || p==null)
            return false;
        int i=0;
        int j=0;
        int posStar = -1;
        int posS = -1;
       
        while(i<s.length()){
            if(j<p.length() && s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }
            
            else if(j<p.length() && p.charAt(j)=='?'){
                i++;
                j++;
            }
            
            else if(j<p.length() && p.charAt(j)=='*'){
                posStar = j; 
                posS = i;
                j++;
                continue;
            }
            
            else if(posStar != -1){
            	i = posS;
            	j = posStar + 1;
            	posS++;
            }
            else {
            	return false;
            }
        }
        
        while(j<p.length() && p.charAt(j)=='*')
        	j++;
        	
        return i==s.length() && j==p.length();
        
    }
}
