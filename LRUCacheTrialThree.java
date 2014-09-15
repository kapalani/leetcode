import java.util.*;
public class LRUCacheTrialThree{

     public static void main(String []args){
        LRUCache lru = new LRUCache(3);
        lru.set(2, 1);
        lru.set(5, 1);
        lru.set(3, 1);
        lru.set(1, 1);
        lru.set(5, 2);
        
        Set<Integer> keySet = lru.map.keySet();
        for(int i:keySet)
            System.out.println(i);
     }
     
    public static class Node {
        public int val;
	    public int key;
	    public Node previous;
	    public Node next;
 
	    public Node(int key, int value) {
		    val = value;
		    this.key = key;
            previous = null;
            next = null;
	    }
    }
    
    public static class LRUCache {
        private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	    private Node head;
	    private Node last;
	    private int capacity;
	    private int len;
    
        public LRUCache(int capacity) {
    	    this.capacity = capacity;
		    len = 0;
	    }
        
        public void removeNode(Node node){
            Node current = node;
            Node previous = current.previous;
            Node next = current.next;
            
            if(previous==null)
                head = next;
            else
                previous.next = next;
                
            if (next==null)
                last = previous;
            else
                next.previous = previous;
        }
        
        public void setHead(Node node) {
            
            node.next = head;
            node.previous = null;
            if(head!=null){
                head.previous = node;
            }
            head = node;
            if(last==null)
                last = node;
        }
        
        public int get(int key){
            if(map.containsKey(key)){
                Node tmp = map.get(key);
                removeNode(tmp);
                setHead(tmp);
                return tmp.val;
            }
            return -1;
        }
        
        public void set(int key, int value) {
            if(map.containsKey(key)){
                Node tmp = map.get(key);
                tmp.val = value;
                removeNode(tmp);
                setHead(tmp);
            }
            else{
                Node node = new Node(key, value);
                
                if(len<capacity){
                    setHead(node);
                    map.put(key, node);
                    len++;
                }else{
                    map.remove(last.key);
                    last = last.previous;
                    if(last!=null)
                        last.next = null;
                    setHead(node);
                    map.put(key, node);
                }
            }
        }
    }
}
