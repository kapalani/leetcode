import java.util.Stack;


public class LargestRectangle {

	public static void main(String[] args) {
		int array[] = {6, 2, 5, 4, 5, 1, 6};
		System.out.println(largestRectangleArea(array));
	}

	public static int largestRectangleArea(int[] height) {
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
