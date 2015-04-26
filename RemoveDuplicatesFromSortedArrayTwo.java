public class RemoveDuplicatesFromSortedArrayTwo {
	public static void main(String[] args) {
		int[] A = {1, 1, 1, 2, 2, 3, 3};
		int length = removeDuplicates(A);
		for (int i:A) {
			System.out.print(i+" ");
		}
	}
	
	private static int removeDuplicates(int[] A) {
		if (A.length <= 2)
			return A.length;
		int start = 1;
		int next = 2;
		
		while(next < A.length) {
			if (A[next] == A[start] && A[next] == A[start-1]) {
				next++;
			} else {
				start++;
				A[start] = A[next];
				next++;
			}
		}
		return start+1;
	}
}
