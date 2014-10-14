import java.util.*;
public class PostorderTraversal{

    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        
        List<Integer> list = postorderTraversal(root);
        System.out.println(list);
    }
    
    public static List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)
            return list;
        helper(root, list);
        return list;
    }
    
    public static void helper(TreeNode root, List<Integer> list){
        if(root==null)
            return;
        helper(root.left, list);
        helper(root.right, list);
        list.add(root.val);
    }
    
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)
            return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer>  result = new Stack<Integer>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            result.push(tmp.val);
            if(tmp.left!=null)
                stack.push(tmp.left);
            if(tmp.right!=null)
                stack.push(tmp.right);
        }
        
        while(!result.isEmpty()){
            list.add(result.pop());
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
