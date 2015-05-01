import java.util.Stack;

public class MinStack {
	Stack<Long> stack;
	long min = Long.MIN_VALUE;
	public MinStack() {
		stack = new Stack<Long>();
	}
	
	public void push(int x) {
        if (stack.isEmpty()) {
        	min = x;
        	stack.push(0L);
        } else {
        	stack.push(x-min);
        	if (x < min) min = x;
        }
    }

    public void pop() {
    	if (stack.isEmpty()) return;
    	long pop = stack.pop();
        if (pop < 0) min = min-pop;
    }

    public int top() {
    	long peek = stack.peek();
        if (peek > 0) {
        	return (int)(min+peek);
        } else {
        	return (int)(min);
        }
    }

    public int getMin() {
    	return (int)min;
    }
}
