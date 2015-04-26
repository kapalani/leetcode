public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] A = {1, 2, 2, 3};
		removeDuplicates(A);
	}
	
	public static int removeDuplicates(int[] A) {
		if (A.length < 2)
        	return A.length;

        int start = 0;
        int next = 1;
        
        while (next < A.length) {
        	if (A[start] == A[next]) {
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
