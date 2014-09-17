public class PalindromeNumber{

    public static void main(String []args){
        boolean result = isPalindrome(1000021);
        System.out.println(result);
    }
     
    public static boolean isPalindrome(int x) {
    
        if(x<0)
            return false;
            
        int left = 0;
        int right = 0;
        
        int tmp = x;
        int ct = 1;
        
        while(tmp/ct>=10){
            ct *= 10;
        }
        
        while(x!=0){
            
            right = x%10;
            left = x/ct;
            
            if(x<10 && left==right)
                return true;
            else if(left!=right)
                return false;
                
            x = x/10;
            x = x%(ct/10);
    
            ct /= 100;
        }
        
        return true;
    }
}

