import java.util.*;
public class TriangleTrialTwo{

    public static void main(String []args){
        List<Integer> a = Arrays.asList(-1);
        List<Integer> b = Arrays.asList(2, 3);
        List<Integer> c = Arrays.asList(1, -1, -3);
        List<List<Integer>> triangle = Arrays.asList(a, b, c);
        int result = minimumTotal(triangle);
        System.out.println(result);
    }
     
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null)
            return 0;
        
       int size = triangle.size();
       int[] tmp = new int[size];
        
        for(int i=0;i<size;i++){
            tmp[i] = triangle.get(size-1).get(i);
        }
        
        for(int i=size-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++)
                tmp[j] = Math.min(tmp[j], tmp[j+1]) + triangle.get(i).get(j);
        }
        
        return tmp[0];
    }
}