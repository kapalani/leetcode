public class PowTrialTwo{

    public static void main(String []args){
        double result = pow(34.00515,-2);
        System.out.println(result);
    }
    
    public static double pow(double x, int n) {
        if(n>0)
            return power(x, n);
        else 
            return 1/power(x, -n);
    }
    
    public static double power(double x, int n){
        if(n==0)
            return 1;
        double val = power(x, n/2);
        if(n%2==0)
            return val * val;
        else
            return val * val * x;
    }
}
