public class LongestCommonPrefix {

     public static void main(String []args){
        String[] arr = {"kavin","kavitha"};
        String result = longestCommonPrefix(arr);
        System.out.println(result);
     }
    
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return null;
        if(strs.length==1)
            return strs[0];
        
        int prev_prefix = strs[0].trim().length()-1;
        
        for(int i=1;i<strs.length;i++){
            if((strs[i].trim().length()-1)<prev_prefix)
                prev_prefix = strs[i].length()-1;
        }
        
        if(prev_prefix<0)
            return "";
        
        int cur_prefix = -1;
        for(int i=0;i<strs.length-1;i++){
            String str1 = strs[i].trim();
            String str2 = strs[i+1].trim();
            for(int j=0;j<=prev_prefix;j++){
                if(str1.length()-1>=j && str2.length()-1>=j && str1.charAt(j)==str2.charAt(j))
                    cur_prefix = j;
                else
                    break;
            }
            if(cur_prefix == -1)
                return "";
            prev_prefix = cur_prefix;
            cur_prefix = -1;
        }
        
        if(prev_prefix<strs[0].length()-1)
            return strs[0].substring(0, prev_prefix+1);
        else 
            return strs[0];
    }
}