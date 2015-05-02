package linkedlist;

public class ConvertSortedArrayToBST {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		sortedArrayToBST(array);
	}
	
	public static TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) return null;
        return helper(num, 0, num.length-1);
    }
	
	public static TreeNode helper(int[] num, int start, int end) {
		if (start > end) return null;
		int mid = start + (end - start)/2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = helper (num, start, mid-1);
		node.right = helper (num, mid+1, end);
		return node;
	}
}
