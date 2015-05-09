
public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(4));
	}

	public static int climbStairs(int n) {
		if (n == 0) return 0;
		
		if (n == 1) return 1;
		
		if (n == 2) return 2;
		
		int[] array = new int[n+1];
		array[0] = 1;
		array[1] = 1;
		
		for (int i=2; i<=n; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		return array[n];
    }
}
