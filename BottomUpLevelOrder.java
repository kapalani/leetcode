import java.util.*;
public class BottomUpLevelOrder{

    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        List<List<Integer>> result = levelOrderBottom(root);
        for(List<Integer> i:result)
            System.out.println(i);
    }
    
    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        int no_nodes_in_current_level = 1;
        int no_nodes_in_next_level = 0;
        
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            no_nodes_in_current_level--;
            if(tmp.right!=null){
                queue.offer(tmp.right);
                no_nodes_in_next_level++;
            }
            if(tmp.left!=null){
                queue.offer(tmp.left);
                no_nodes_in_next_level++;
            }
            stack.push(tmp);
            if(no_nodes_in_current_level==0){
                stack.push(null);
                no_nodes_in_current_level=no_nodes_in_next_level;
                no_nodes_in_next_level = 0;
            }
            
        }
        
        while(!stack.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            //Remove if null
            if(stack.peek()==null)
                stack.pop();
            while(!stack.isEmpty() && stack.peek()!=null){
                TreeNode tmp = stack.pop();
                if(tmp!=null){
                    list.add(tmp.val);
                }
            }
            result.add(list);
        }
        
        return result;
    }
    
}
