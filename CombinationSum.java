import java.util.*;
import java.lang.*;
import java.io.*;
public class CombinationSum{

  public static void main (String[] args) throws java.lang.Exception
  {
		int[] a = {8, 7, 4, 3};
		List<List<Integer>> result = combinationSum(a, 11);
		for(List<Integer> l:result)
			System.out.println(l);
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(candidates == null||candidates.length<0){
      return result;
    }
        
    Arrays.sort(candidates);
    List<Integer> current = new ArrayList<Integer>();
    buildResult(candidates, 0, current, target, result);
    return result;
  }
    
   public static void buildResult(int[] candidates, int start, List<Integer> current, int target, List<List<Integer>> result){
      if(target==0){
          List<Integer> tmp = new ArrayList<Integer>();
          tmp.addAll(current);
          result.add(tmp);
          return;
      }
        
      for(int i=start;i<candidates.length;i++){
        if(target<candidates[i])
          return;
        current.add(candidates[i]);
        buildResult(candidates, i, current, target-candidates[i], result);
        current.remove(current.size()-1);
      }
    }
}
