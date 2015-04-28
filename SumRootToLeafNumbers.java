
public class SumRootToLeafNumbers {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		node.left = two;
		node.right = new TreeNode(3);
		two.left = new TreeNode(4);
		two.right = new TreeNode(5);
		
		int result = sumNumbers(node);
		System.out.println(result);
		
	}

	public static int sumNumbers(TreeNode root) {
		return sumHelper(root);
    }
	
	public static int sumHelper(TreeNode node) {
		if (node == null) return 0;
		
		if (node.left == null && node .right == null) {
			return node.val;
		}
		
		if (node.left != null) {
			node.left.val = (node.val * 10) + node.left.val;
		}
		
		if (node.right != null) {
			node.right.val = (node.val * 10) + node.right.val;
		}
		
		int left = sumHelper(node.left);
		int right = sumHelper(node.right);
		
		return left+right;
	}
}
