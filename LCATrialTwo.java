public class LCATrialTwo{

    public static void main(String []args){
        Node root = new Node(3);
        Node l = new Node(5);
        l.parent = root;
        root.left = l;
        
        Node r = new Node(1);
        r.parent = root; 
        root.right = r;
        
        Node ll = new Node(6);
        ll.parent = l;
        root.left.left = ll;
        
        Node lr = new Node(2);
        lr.parent = l;
        root.left.right = lr;
        
        Node lrl = new Node(7);
        lrl.parent = lr;
        root.left.right.left = lrl;
        
        Node lrr = new Node(4);
        lrr.parent = lr;
        root.left.right.right = lrr;
        
        Node result = LCA(lrl, lrr);
        System.out.println(result.val);
    }
    
    public static Node LCA(Node a, Node b){
        if(a==null || b==null)
            return null;
            
        int h1 = getHeight(a);
        int h2 = getHeight(b);
        if(h1>h2){
            int tmp = h1;
            h1 = h2;
            h2 = tmp;
            
            Node t = a;
            a = b;
            b = t;
        }
        
        int dh = h2-h1;
        for(int i=0;i<dh;i++)
            a = a.parent;
        while(a!=null && b!=null){
            if(a==b)
                return a;
            a = a.parent;
            b = b.parent;
        }
        
        return null;
    }
    
    public static int getHeight(Node node){
        if(node==null)
            return 0;
        int ht = 0;
        while(node!=null){
            ht++;
            node = node.parent;
        }
        return ht;
    }
    
    
}

class Node{
    Node left;
    Node right;
    Node parent;
    int val;
    Node(int val){
        this.val = val;
    }
    
}
