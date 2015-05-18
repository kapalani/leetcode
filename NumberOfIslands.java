package leetcode;

//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
//An island is surrounded by water and is formed by connecting adjacent lands
//horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

public class NumberOfIslands {
	public static void main(String[] args) {
		char[][] grid = {{'1', '1', '0', '0', '0'},
						 {'0', '1', '0', '0', '0'},
						 {'0', '0', '1', '0', '0'},
						 {'0', '0', '0', '1', '1'}};
		System.out.println(numIslands(grid));
	}

	public static int numIslandsWrong(char[][] grid) {
		if (grid.length == 0) return 0;
		
		int ct = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0 && j == 0) {
					if (grid[i][j] == '1')
						ct = 1;
				} else if (i == 0) {
					if (grid[i][j] == '1' && grid[i][j-1] != '1')
						ct += 1;
				} else {
					if (j == 0) {
						if (grid[i][j] == '1' && grid[i-1][j] != '1')
							ct += 1;
					} else {
						if (grid[i][j] == '1' && grid[i][j-1] != '1' && grid[i-1][j] != '1') {
							ct += 1;
						}
					}	
				}
			}
		}
		
		return ct;
    }
	
	public static int numIslands(char[][] grid) {
		if (grid.length == 0) return 0;
		
		int ct = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					ct += 1;
					dfshelper(grid, i, j);
				}
			}
		}
		
		return ct;
	}
	
	public static void dfshelper (char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
			return;
		if (grid[i][j] != '1') return;
		grid[i][j] = '2';
		dfshelper(grid, i-1, j);
		dfshelper(grid, i+1, j);
		dfshelper(grid, i, j-1);
		dfshelper(grid, i, j+1);
	}
	
}
