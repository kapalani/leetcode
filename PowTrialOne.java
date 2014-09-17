public class PowTrialOne{

    public static void main(String []args){
        double result = pow(3, 2);
        System.out.println(result);
    }
     
    public static double pow(double x, int n) {
        if(x==0)
            return 1;
        if(n==0)
            return 1;
            
        double val = x;
        for(int i=1;i<n;i++){
            val = val * val;
        }
        
        return val;
    }
}