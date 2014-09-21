import java.util.*;

public class ZigZag {
	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(8);
		root.right.left.right = new TreeNode(6);
		root.right.right.left = new TreeNode(1);
		root.right.right.right = new TreeNode(5);
		
		List<List<Integer>> result = zigzagLevelOrder(root);
		for(List<Integer> i: result)
			System.out.println(i);
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root==null)
			return result;
		
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			List<Integer> list = new ArrayList<Integer>();
			if(!stack1.isEmpty()){
				while(!stack1.isEmpty()){
					TreeNode tmp = stack1.pop();
					list.add(tmp.val);
					if(tmp.left!=null)
						stack2.push(tmp.left);
					if(tmp.right!=null)
						stack2.push(tmp.right);
				}
				result.add(list);
			}else {
				while(!stack2.isEmpty()){
					TreeNode tmp = stack2.pop();
					list.add(tmp.val);
					if(tmp.right!=null)
						stack1.push(tmp.right);
					if(tmp.left!=null)
						stack1.push(tmp.left);
				}
				result.add(list);
			}
		}
		
		return result;
    }
}
