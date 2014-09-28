public class UniqueBST{

    public static void main(String []args){
        int result = numTrees(4);
        System.out.println(result);
    }
    
    public static int numTrees(int n) {
        return helper(n);
    }
    
    public static int helper(int n){
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        else if(n==2)
            return 2;
        int val = 0;
        int x = 0;
        
        for(int i=n-1;i>(n-1)/2;i--){
            
                val += helper(i) * helper(x);
                x++;
            }
        
        if(n%2==0){
            return 2 * val;
        } else {
            
            val *= 2;
            val += helper(x) * helper(x);
            return val;
        }
    }
}
