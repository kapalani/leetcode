import java.util.*;
public class LRUCacheTrialOne{

     public static void main(String []args){
        LRUCache lru = new LRUCache(3);
        lru.set(2, 1);
        lru.set(5, 1);
        lru.set(3, 1);
        lru.set(1, 1);
        lru.set(5, 2);
        
        while(lru.queue.peek()!=null)
            System.out.print(lru.queue.poll());   
        System.out.println();
        
        Set<Integer> keySet = lru.map.keySet();
        for(int i:keySet)
            System.out.println(i+" : "+lru.map.get(i));
        
     }
     
    public static class LRUCache {
    
        int capacity;
        Queue<Integer> queue;
        Map<Integer, Integer> map; 
        
        public LRUCache(int capacity) {
            this.capacity = capacity;
            queue = new LinkedList<Integer>();
            map = new HashMap<Integer,Integer>();
        }
    
        public int get(int key) {
            if(!map.containsKey(key))
                return -1;
            return map.get(key);
        }
    
        public void set(int key, int value) {
            
            //Empty queue
            if(queue.size()==0){
                queue.offer(key);
                map.put(key, value);
                return;
            } 
            
            //Queue has not reach its capacity
            if(queue.size()<capacity){
                if(map.containsKey(key))
                        rearrangeQueue(queue, key);
                queue.offer(key);
                map.put(key,value);
                return;
            }
            
            //Queue has reached its capacity
            
            //If the key is not in the map add it and to the queue
            if(!map.containsKey(key)) {
                int val = queue.poll();
                queue.offer(key);
                map.remove(val);
                map.put(key, value);
            }
            //Else, the map and queue already have the key
            else {
                rearrangeQueue(queue, key);
                queue.offer(key);
                map.put(key,value);
            }
        }
        
        private void rearrangeQueue(Queue<Integer> queue,int key){ 
            while(queue.size()>0 && queue.peek()!=key)
                queue.offer(queue.poll());
            queue.poll();   
            while(queue.size()>0)
                queue.offer(queue.poll());
        }
    }
}
