import java.util.Stack;
public class SpecialStack extends Stack<Integer> {
	Stack<Integer> minStack;
	
	public SpecialStack() {
		minStack = new Stack<Integer>();
	}
	
	public void push(int x){
		if(super.isEmpty()){
			super.push(x);
			minStack.push(x);
		}else{
			int currentMin = minStack.pop();
			minStack.push(currentMin);
			if(x<currentMin)
				minStack.push(x);
			else
				minStack.push(currentMin);
		}
	}
	
	public Integer pop(){
		minStack.pop();
		return (int)super.pop();
	}
	
	public int getMin(){
		int min = minStack.pop();
		minStack.push(min);
		return min;
	}
	
	public static void main(String[] args){
		SpecialStack s = new SpecialStack();
	    s.push(10);
	    s.push(20);
	    s.push(30);
	    System.out.println(s.getMin());
	    s.push(5);
	    System.out.println(s.getMin());
	}
}
