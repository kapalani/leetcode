import java.util.*;
public class LRUCacheTrialTwo{

     public static void main(String []args){
        LRUCache lru = new LRUCache(3);
        lru.set(2, 1);
        lru.set(5, 1);
        lru.set(3, 1);
        lru.set(1, 1);
        lru.set(5, 2);
        
        Set<Integer> keySet = lru.map.keySet();
        for(int i:keySet)
            System.out.println(i+" : "+lru.map.get(i));
     }
     
     public static class LRUCache {
    
        int capacity;
        Map<Integer, Integer> map; 
        
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<Integer,Integer>();
        }
    
        public int get(int key) {
            if(!map.containsKey(key))
                return -1;
            return map.get(key);
        }
    
        public void set(int key, int value) {
        
            if(map.size()==0){
                map.put(key, value);
                return;
            } 
            
            //Map has not reach its capacity
            if(map.size()<capacity){
                if(map.containsKey(key)){
                    map.remove(key);
                }
                map.put(key,value);
                return;
            }
            
            //Queue has reached its capacity  
            //If the key is not in the map add it and to the queue
            if(!map.containsKey(key)) {
                Set<Integer> keySet = map.keySet();
                int k = (int)keySet.toArray()[0];
                map.remove(k);
                map.put(key, value);
            }
            //Else, the map and queue already have the key
            else {
                map.remove(key);
                map.put(key,value);
            }
        }
    }
}
