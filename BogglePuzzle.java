import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BogglePuzzle {
	static TrieNode root;
    public static void main(String []args){
        root = new TrieNode();
        root.addWord("pec");
        root.addWord("vie");
        root.addWord("bot");
        root.addWord("pot");
        root.addWord("bit");
        root.addWord("biop");
        root.addWord("zion");
        
        char[][] arr = {{'a', 'c', 'v'},{'e','i','b'},{'p','o','t'}};
        List<String> result = getWords(arr);
        for(String s:result){
    		System.out.println(s);
		}
    }
    
    public static List<String> getWords(char[][] arr){
        Queue<Elem> queue = new LinkedList<Elem>();
        List<String> list = new ArrayList<String>();
        List<Point> points = addPoints();
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                TrieNode node = root.getNode(arr[i][j]);
                if(node!=null){
                    Elem e = new Elem(i, j, arr[i][j]+"", node);
                    queue.offer(e);
                }
            }
        }
        
        while(!queue.isEmpty()){
            Elem e = queue.poll();
            int x = e.x;
            int y = e.y;
            String c = e.c;
            TrieNode node = e.node;
            for(Point p: points){
               int x1 = x+p.x;
               int y1 = y+p.y;
               if(x1>=0 && x1<arr.length && y1>=0 && y1<arr[0].length){
            	   String c1 = c+arr[x1][y1];
            	   TrieNode tmp = node.getNode(arr[x1][y1]);
            	   if(tmp!=null){
            		   if(tmp.isWord)
            			  list.add(c1);
            		   queue.offer(new Elem(x1, y1, c1, tmp));
            	   }
            	    
               }
            }
        }
        
        return list;
    }
    
    public static List<Point> addPoints(){
    	List<Point> points = new ArrayList<Point>();
        points.add(new Point(0, -1));
        points.add(new Point(0, 1));
        points.add(new Point(1, -1));
        points.add(new Point(1, 1));
        points.add(new Point(-1, -1));
        points.add(new Point(-1, 1));
        points.add(new Point(1, 0));
        points.add(new Point(-1, 0));
        
        return points;
    }
}

class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class TrieNode{
    TrieNode parent;
    TrieNode[] children;
    private boolean isLeaf;
    public boolean isWord;
    private char character;
    
    public TrieNode(){
        children = new TrieNode[26];
        isLeaf = true;
        isWord = false;
    }
    
    public TrieNode(char c){
        this();
        this.character = c;
    }
    
    public TrieNode getNode(char c){
        return children[c-'a'];
    }
    
    public void addWord(String word){
        isLeaf = false;
        int charPos = word.charAt(0)-'a';
        
        if(children[charPos]==null){
            children[charPos] = new TrieNode(word.charAt(0));
            children[charPos].parent = this; 
        }
        if(word.length()>1)
            children[charPos].addWord(word.substring(1));
        else
            children[charPos].isWord = true;
    }
    
    public List<String> getWords(){
        List<String> list = new ArrayList<String>();
        if(isWord)
            list.add(toString());
        if(!isLeaf){
            for(int i=0;i<children.length;i++){
                if(children[i]!=null)
                    list.addAll(children[i].getWords());
            }
        }
        return list;
    }
    
    public String toString(){
        if(parent==null)
            return "";
        return parent.toString() + character;
    }
}

class Elem{
    int x;
    int y;
    String c;
    TrieNode node;
    Elem(int x, int y, String c, TrieNode node){
        this.x = x;
        this.y = y;
        this.c = c;
        this.node = node;
    }

}
