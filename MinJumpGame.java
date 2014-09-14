public class MinJumpGame{

    public static void main(String []args){
        int[] arr = {2, 3, 1, 1, 4};
        int result = jump(arr);
        System.out.println(result);
    }
     
    public static int jump(int[] A) {
        if(A.length==0)
            return 0;
        int[] tmp = new int[A.length];
        tmp[0] = 0;
        
        for(int i=1;i<A.length;i++){
            tmp[i] = Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                if(A[j]+j>=i){
                    tmp[i] = Math.min(tmp[i], tmp[j]+1);
                    break;
                }
            }
        }
        
        return tmp[tmp.length-1];
    }
    
}
