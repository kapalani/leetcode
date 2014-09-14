import java.lang.*;
import java.io.*;
public class JumpGame{

    public static void main(String []args){
		int arr[] = {2, 1, 0, 3};
		boolean result = canJump(arr);
		System.out.println(result);
    }
     
    public static boolean canJump(int[] A) {
		if(A.length==0)
			return true;
        
        int max = 0;
        int j = 1;
        for(int i=0;i<A.length;i++){
            j--;
            if(i+A[i]>max){
                max = i+A[i];
                j = A[i];
            }
            if(j==0&&i<A.length-1)
                return false;
        }
        
        return true;
    }
}
