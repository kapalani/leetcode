import java.util.*;
public class PascalsTriangleII{

    public static void main(String []args){
         List<Integer> result =  getRow(5);
         System.out.println(result);
    }
     
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
            
        int[] row = new int[rowIndex+1];
        row[0]=1;
        
        for(int i=1;i<=rowIndex;i++){
            row[i]=1;
            for(int j = i - 1; j > 0; j--)
                row[j] = row[j] + row[j-1];
        }
    
        for(int i: row)
            result.add(i);
        return result;
    }
    
}
