import java.util.*;
public class FlattenBTree{

     public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        
        flatten(root);
        while(root!=null){
            System.out.print(root.val);
            if(root.right!=null)
                System.out.print("->");
            root = root.right;
        }
     }
     
     public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    
    public static void flatten(TreeNode root) {
        if(root==null)
            return;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        TreeNode previous = null;
        
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(previous!=null)
                previous.right = tmp;

            if(tmp.right!=null)
                stack.push(tmp.right);
            if(tmp.left!=null)
                stack.push(tmp.left);
            
            if(tmp.left!=null){
                TreeNode t = tmp.left;
                tmp.left = null;
                tmp.right = t;
            }
            
            previous = tmp;
        }
    }
}
