import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	public static void main(String[] args){
		UndirectedGraphNode root = new UndirectedGraphNode(0);
		root.neighbors.add(new UndirectedGraphNode(1));
		root.neighbors.add(new UndirectedGraphNode(2));

		UndirectedGraphNode head = cloneGraph(root);
		
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.offer(head);
		while(!queue.isEmpty()){
			UndirectedGraphNode tmp = queue.poll();
			System.out.println(tmp.label);
			for(UndirectedGraphNode node:tmp.neighbors){
				queue.offer(node);
			}
		}
	}
	
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
		if(node==null)
			return null;
		
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        queue.offer(node);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        
        while(!queue.isEmpty()){
        	UndirectedGraphNode tmp = queue.poll();
        	for(int i=0;i<tmp.neighbors.size();i++){
        		UndirectedGraphNode neighbor = tmp.neighbors.get(i);
        		if(!map.containsKey(neighbor)){
        			UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
        			map.get(tmp).neighbors.add(neighborCopy);
        			map.put(neighbor, neighborCopy);
        			queue.offer(neighbor);
        		}else{
        			map.get(tmp).neighbors.add(neighbor);
        		}
        	}
        }
        
        return copy;
    }
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
