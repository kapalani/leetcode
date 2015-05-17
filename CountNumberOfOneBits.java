package leetcode;

public class CountNumberOfOneBits {
	public static void main (String[] args) {
		System.out.println(hammingWeight(2147483647));
	}
	
	public static int hammingWeightNaive(int n) { 
		if (n > Integer.MAX_VALUE) return 0;
		System.out.println(Integer.MAX_VALUE);
		if (n == 0) return 0;
		
		int ct = 0;
		int shift = 0;
		for (int i = 1; i <= n; i = 2 * i) {
			if ((n & 1 << shift) >= 1) {
				ct++;
			}
			shift++;
		}
		return ct;
    }
	
	public static int hammingWeightBetter(int n) {
		int count = 0;
		if (n > Integer.MAX_VALUE) return 1;
	    while (n > 0) {           // until all bits are zero
	        if ((n & 1) == 1)     // check lower bit
	            count++;
	        n >>= 1;              // shift bits, removing lower bit
	    }
	    return count;
	}
	
	public static int hammingWeight(int n) {
		int count = 0;
		for (int i=1; i <=32; i++) {
			if ((n & 1 << i) >= 1) {
				count++;
			}
		}
		
		return count;
	}
}
