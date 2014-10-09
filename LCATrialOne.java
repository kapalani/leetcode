public class LCATrialOne{

    public static void main(String []args){
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        Node a = new Node(2);
        root.left.right = a;
        root.left.right.left = new Node(7);
        Node b = new Node(4);
        root.left.right.right = b;
        Node result = LCA(root, a, b);
        System.out.println(result.val);
    }
    
    public static Node LCA(Node root, Node a, Node b){
        if(root==null || a==null || b==null)
            return null;
        if(root==a || root==b)
            return root;
            
        int ct = totalMatches(root.left, a, b);
        if(ct==1)
            return root;
        else if(ct==2)
            return LCA(root.left, a, b);
        else
            return LCA(root.right, a, b);
    }
    
    public static int totalMatches(Node root, Node a, Node b){
        if(root==null)
            return 0;
        int ct = totalMatches(root.left, a, b) + totalMatches(root.right, a, b);
        if(root==a || root==b)
            return 1 + ct;
        else
            return ct;
    }
    
    
}

class Node{
    Node left;
    Node right;
    int val;
    Node(int val){
        this.val = val;
    }
    
}
