import java.util.Stack;

public class MaximalRectangle {
	
	public static void main(String[] args) {
		char[][] array = {{'0', '0', '0', '1', '0'},
						  {'0', '1', '1', '0', '1'}, 
						  {'0', '1', '1', '1', '0'}, 
						  {'0', '0', '1', '0', '1'}};
		
		System.out.println(maximalRectangle(array));
		
	}

	public static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		
		int[][] heights = new int[matrix.length][matrix[0].length];
		
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if (i==0)
					heights[i][j] = (matrix[i][j] == '0') ? 0 : 1;
				else 
					heights[i][j] = (matrix[i][j] == '0') ? 0 : 1+heights[i-1][j];
			}
		}
		
		int max = 0;
		for (int i=0; i<heights.length; i++) {
			max = Math.max(max, largestRectangleArea(heights[i]));
		}

		return max;
	}
	
	private static int largestRectangleArea(int[] height) {
        if (height.length == 0) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int max = 0;
        int i = 0;
        
        while(i < height.length) {
        	if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
        		stack.push(i++);
        	} else {
        		int h = height[stack.pop()];
        		int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
        		if (h * w > max) max = h * w;
        	}
        }
        
        while(!stack.isEmpty()) {
        	int h = height[stack.pop()];
    		int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
    		if (h * w > max) max = h * w;
        }
        
        return max;
    }
}
