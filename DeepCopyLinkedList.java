import java.util.*;
public class DeepCopyLinkedList{

    public static void main(String []args){
        RandomListNode head = new RandomListNode(-1);
        head.next = new RandomListNode(1);
        head.random = new RandomListNode(2);
        head.next.next = head.random;
        
        RandomListNode root = copyRandomList(head);
        RandomListNode copy = root;
        //Next pointers
        while(root!=null){
            System.out.print(root.label);
            if(root.next!=null)
                System.out.print("->");
            root = root.next;
        }
        
        System.out.println();
        
        //Random pointers
        while(copy!=null){
            System.out.print(copy.label);
            if(copy.random!=null)
                System.out.print("->");
            copy = copy.random;
        }
    }
    
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        
        HashMap<RandomListNode, RandomListNode> table = 
        new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode root = new RandomListNode(head.label);
        RandomListNode copy = root;
        table.put(head, root);
        
        while(head.next!=null){
            
            if(!table.containsKey(head.next)){
                RandomListNode random = new RandomListNode(head.next.label);
                table.put(head.next, random);
                root.next = random;
            }else{
                root.next = table.get(head.next);   
            }
            
            if(head.random!=null){
                if(!table.containsKey(head.random)){
                    RandomListNode random = new RandomListNode(head.random.label);
                    table.put(head.random, random);
                    root.random = random;
                }else{
                    root.random = table.get(head.random);
                }
            }
            head = head.next;
            root = root.next;
        }
        
        if(head.random!=null){
            if(!table.containsKey(head.random)){
                    RandomListNode random = new RandomListNode(head.random.label);
                    table.put(head.random, random);
                    root.random = random;
                }else{
                    root.random = table.get(head.random);
                }
        }
        
        
        return copy;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
