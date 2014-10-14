public class BalancedBTree{

    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        //root.left.left.left = new TreeNode(5);
        boolean result = isBalanced(root);
        System.out.println(result);
    }
    
    public static boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int h = helper(root);
        if(h==-1)
            return false;
        return true;
    }
    
    public static int helper(TreeNode root){
        if(root==null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        
        if (left == -1 || right == -1)
    		return -1;
            
        if(Math.abs(left-right)>1)
            return -1;
            
        return Math.max(left, right)+1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
