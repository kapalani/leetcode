public class PowerSet {
	public static void main(String[] args){
		int[] arr = {4, 1, 0};
		List<List<Integer>> result = subsets(arr);
		for(List<Integer> list:result)
				System.out.println(list);
	}
	
	public static List<List<Integer>> subsets(int[] S){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(S.length==0)
				return new ArrayList<List<Integer>>(result);
		
		int pow_set_size = (int) Math.pow(2, S.length);
		
		for(int i=0;i<pow_set_size;i++){
			List<Integer> list = new ArrayList<Integer>();
			for(int j=0;j<S.length;j++){
				if((i & (1<<j)) > 0)
					list.add(S[j]);
			}
			Collections.sort(list);
			result.add(list);
		}
		
		Collections.sort(result, new CustomComparator());
		return result;
		
	}
}

class CustomComparator implements Comparator<List<Integer>>{

	@Override
	public int compare(List<Integer> o1, List<Integer> o2) {
		return o1.size()-o2.size();
	}
	
}
