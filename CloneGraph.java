import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	public static void main(String[] args){
		
	}
	
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        	if (node == null) return null;
        
                Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        	Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        	UndirectedGraphNode firstCopy = new UndirectedGraphNode(node.label);
        	queue.offer(node);
        	map.put(node, firstCopy);
        
        	while(!queue.isEmpty()) {
        		UndirectedGraphNode current = queue.poll();
        	
        		for (UndirectedGraphNode neighbour:current.neighbors) {
        			if (!map.containsKey(neighbour)) {
        				UndirectedGraphNode copy = new UndirectedGraphNode(neighbour.label);
        				queue.add(neighbour);
        				map.put(neighbour, copy);
        				map.get(current).neighbors.add(copy);
        			} else {
        				map.get(current).neighbors.add(map.get(neighbour));
        			}
        		}		
        	}
        
        	return firstCopy;
    	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
