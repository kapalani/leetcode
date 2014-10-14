import java.util.*;
public class PreorderTraversal{

    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        
        List<Integer> list = preorderTraversalRecursive(root);
        System.out.println(list);
    }
    
    public static List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)
            return list;
        helper(root, list);
        return list;
    }
    
    public static void helper(TreeNode root, List<Integer> list){
        if(root==null)
            return;
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }
    
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)
            return list;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            if(tmp.right!=null)
                stack.push(tmp.right);
            if(tmp.left!=null)
                stack.push(tmp.left);
        }
        
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
