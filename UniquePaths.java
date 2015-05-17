package leetcode;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//The robot can only move either down or right at any point in time. 
//The robot is trying to reach the bottom-right corner of the grid 
//(marked 'Finish' in the diagram below).
//How many possible unique paths are there?

public class UniquePaths {

	public static void main (String args[]) {
		System.out.println(uniquePathsDP(3, 7));
	}
	
	public static int uniquePathsRecursive(int m, int n) {
        return recursiveHelper(m, n, 1, 1);
    }
	
	private static int recursiveHelper(int m, int n, int i, int j) {
		if (i == m || j == n)
			return 1;
		return recursiveHelper(m, n, i+1, j) + recursiveHelper(m, n, i, j+1);
	}
	
	public static int uniquePathsDP(int m, int n) {
		if (m == 0 || n == 0) return 1;
		int[][] temp = new int[m][n];
		for (int i = 0; i < m; i++) {
			temp[i][0] = 1;
		}
		
		for (int j = 0; j < n; j++) {
			temp[0][j] = 1;
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				temp[i][j] = temp[i-1][j] + temp[i][j-1];
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
		return temp[m-1][n-1];
    }
}
