
public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{11, 12, 13, 14, 15},
						{21, 22, 23, 24, 25},
						{31, 32, 33, 34, 35},
						{41, 42, 43, 44, 45}};
		printSpiralMatrix(matrix);
	}
	
	private static void printSpiralMatrix(int[][] matrix) {
		
		if (matrix.length == 0) return;

		int row_start = 0;
		int row_end = matrix.length-1;
		int col_start = 0;
		int col_end = matrix[0].length-1;
		
		while(row_start <= row_end && col_start <= col_end) {

			//left to Right
			for (int i = col_start; i <= col_end; i++)
				System.out.print(matrix[row_start][i] + " ");
			row_start++;
			
			//top to Bottom
			for (int i = row_start; i <= row_end; i++)
				System.out.print(matrix[i][col_end] + " ");
			col_end--;
			
			//right to Left
			if (row_start <= row_end) {
				for (int i = col_end; i >= col_start; i--)
					System.out.print(matrix[row_end][i] + " ");
				row_end--;
			}
			
			//bottom to top
			if (col_start <= col_end) {
				for (int i = row_end; i >= row_start; i--)
					System.out.print(matrix[i][col_start] + " ");
				col_start++;
			}
		}
	}
}
