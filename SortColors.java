public class SortColors {
	public static void main(String[] args) {
		int[] A = {1, 0, 2, 0};
		sortColors(A);
	}
	
	public static void sortColors(int[] A) {
		if (A == null || A.length < 2)
			return;
		
		int leftPointer = 0;
		int rightPointer = A.length-1;
		int i = 0;
		while(i<=rightPointer) {
			if (A[i] == 0) {
				swap(A, leftPointer, i);
				i++;
				leftPointer++;
			} else if (A[i] == 1) {
				i++;
			} else {
				swap(A, rightPointer, i);
				rightPointer--;
			}
		}
		
		for (int k:A) {
			System.out.print(k+" ");
		}
    }
	
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
