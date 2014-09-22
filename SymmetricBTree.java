public class SymmetricBTree{

    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        
        boolean result = isSymmetric(root);
        System.out.println(result);
    }
    
    public static boolean isSymmetricRecursive(TreeNode root){
        if(root==null)
            return true;
        return helper(root.left, root.right);
    }
    
    public static boolean helper(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return true;
        if(left==null||right==null)
            return false;
        return left.val==right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }
	
	public static boolean isSymmetric(TreeNode root){
        if(root==null||(root.left==null && root.right==null))
            return true;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root.left);
        s2.push(root.right);
        
        while(!s1.isEmpty() && !s2.isEmpty()){
            TreeNode a = s1.pop();
            TreeNode b = s2.pop();
            if(a==null && b==null)    
                continue;
            if(a==null || b==null)
                return false;
            if(a.val!=b.val)
                return false;
            s1.push(a.left);
            s2.push(b.right);
            s1.push(a.right);
            s2.push(b.left);
        }
       return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}