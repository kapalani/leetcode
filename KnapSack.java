public class KnapSack{

    public static void main(String []args){
        int v[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int  W = 50;
        int result = dynamic(W, wt, v, wt.length);
        System.out.println(result);
    }
    
    public static int knapSack(int W, int[] wt, int[] v, int n){
        if(W==0 || n==0)
            return 0;
        if(wt[n-1] > W)
            return knapSack(W, wt, v, n-1);
        return Math.max(v[n-1]+knapSack(W-wt[n-1], wt, v, n-1), 
        knapSack(W, wt, v, n-1));
    }
    
    public static int dynamic (int W, int[] wt, int[] v, int n){
        int[][] tmp = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int w=0;w<=W;w++){
                if(i==0||w==0)
                    tmp[i][w]=0;
                else if(wt[i-1] <= w)
                    tmp[i][w] = Math.max(v[i-1]+tmp[i-1][w-wt[i-1]],
                                tmp[i-1][w]);
                else
                    tmp[i][w] = tmp[i-1][w];
            }
        }
        
        return tmp[n][W];
    }
}
