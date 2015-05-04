
public class MaxAreaContainer {
	public static void main(String[] args) {
		int[] array = {5, 1, 6, 2};
		System.out.println(maxArea(array));
	}
	
	public static int maxArea(int[] height) {
		if (height.length == 0) return -1;
		
		int left = 0;
		int right = height.length-1;
		int max = 0;
		
		while (left < right) {
			int currentMax = (right - left) * Math.min(height[left], height[right]);
			if (currentMax > max) {
				max = currentMax;
			}
			
			if (height[left] < height[right]) 
				left++;
			else 
				right--;	
		}
		
		return max;
	}
}
