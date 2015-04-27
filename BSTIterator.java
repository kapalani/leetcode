import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> stack;
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		populateStack(root);
    }
	
	private void populateStack(TreeNode node) {
		while(node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	/** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return (!stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode node = stack.pop();
    	int val = node.val;
    	if (node.right != null) {
    		populateStack(node.right);
    	}
    	return val;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x) { val = x; };
}
