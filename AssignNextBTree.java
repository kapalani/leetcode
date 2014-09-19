public class AssignNextBTree{  
	
	public static void  main(String args[]){
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		
		connect(root);
	}
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}

	public static void connect(TreeLinkNode root) {
        if(root==null)
            return;
        if(root.left!=null)
            root.left.next = root.right;
        if(root.right!=null)
            root.right.next = root.next != null ? root.next.left :null;
        connect(root.left);
        connect(root.right);
    }    
}