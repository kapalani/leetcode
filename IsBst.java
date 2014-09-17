public class IsBst{

    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        //root.right = new TreeNode(5);
        
        boolean result = isValidBST(root);
        System.out.println(result);
    }
    
    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    
    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static boolean isValid(TreeNode root, int min, int max){
        
        if(root==null)
            return true;
        if(root.val< min || root.val > max)
            return false;
        return isValid(root.left, min, root.val-1) && isValid(root.right, root.val+1, max);
    }
}