public class SameTree{

    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        
        TreeNode rootTwo = new TreeNode(1);
        rootTwo.left = new TreeNode(2);
        rootTwo.right = new TreeNode(5);
        rootTwo.left.left = new TreeNode(3);
        rootTwo.left.right = new TreeNode(4);
        rootTwo.right.right = new TreeNode(6);
        
        boolean result = isSameTree(root, rootTwo);
        System.out.println(result);
    }
    
    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
       
        if(p==null || q==null)
            return false;
        
       if(p.val==q.val)
            return  isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;
    }
}