import java.util.*;
public class PascalsTriangleI{

    public static void main(String []args){
         List<List<Integer>> result =  generate(5);
         for(List<Integer> i:result)
            System.out.println(i);
    }
     
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
         
        if(numRows==0)
            return null;
       
        result.add(Arrays.asList(1));
        
        List<Integer> previous = result.get(0);
        for(int i=1;i<numRows;i++){
            List<Integer> current = new ArrayList<Integer>();
            current.add(0, previous.get(0));
            for(int j=1;j<i;j++){
                current.add(j, previous.get(j-1)+previous.get(j));
            }
            current.add(i, previous.get(i-1));
            
            result.add(current);
            
            previous = current;
        }
        
        return result;
    }
}
