public class PalindromeNumber{

    public static void main(String []args){
        boolean result = isPalindrome(-1221);
        System.out.println(result);
    }
     
    public static boolean isPalindrome(int x) {
    
        if(x<0)
            return false;
            
        int left = 0;
        int right = 0;
        
        int tmp = x;
        int ct = 0;
        
        while(tmp!=0){
            ct +=1;
            tmp = tmp/10;
        }
        
        while(x!=0){
            
            right = x%10;
            if(ct>1)
                left = x/(int)(Math.pow(10, (ct-1)));
            else
                return true;
    
            if(left!=right)
                return false;
            x = x/10;
            if(ct>2)
                x = x%(int)(Math.pow(10, (ct-2)));
            ct -= 2;
        }
        
        return true;
    }
}
