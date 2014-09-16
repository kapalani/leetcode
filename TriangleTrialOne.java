import java.util.*;
public class TriangleTrialOne{

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
        
        List<List<Integer>> tmp = new ArrayList<List<Integer>>();
        for(int i=0;i<triangle.size()-1;i++){
            List<Integer> list = new ArrayList<Integer>();
            tmp.add(list);
        }
        
        //Add the first list from triangle to tmp
        List<Integer> previous = new ArrayList<Integer>();
        previous.add(triangle.get(0).get(0));
        tmp.add(0, previous);
        
        List<Integer> current = null; 
        List<Integer> temp = null;
        
        for(int i=1;i<triangle.size();i++){
            current = tmp.get(i);
            current.add(0,previous.get(0)+triangle.get(i).get(0));
            
            for(int j=1;j<triangle.get(i).size()-1;j++){
                int a = previous.get(j-1)+triangle.get(i).get(j);
                int b = previous.get(j)+triangle.get(i).get(j);
                current.add(j, Math.min(a, b));
            }
            
            int s = triangle.get(i).size()-1;
            current.add(s, previous.get(s-1)+triangle.get(i).get(s));
            
            previous = current;
        }
        
        List<Integer> result = tmp.get(tmp.size()-1);
        int min = Integer.MAX_VALUE;
        for(int i:result){
            if(i<min)
                min = i;
        }
        
        return min;
    }
}

