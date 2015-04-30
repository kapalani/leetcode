import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParantheses {
	public static void main(String[] args) {
		String s = "([]){}";
		System.out.println(isValid(s));
	}
	
	public static boolean isValid(String s) {
        if (s == null) return false;
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        for (int i=1; i<s.length(); i++) {
        	char a = s.charAt(i);
        	char b = 0;
        	if (!stack.isEmpty())
        		b = stack.peek();
        	if (map.containsKey(a)) {
        		stack.push(a);
        	} else if (map.containsKey(b) && map.get(b).equals(a)) {
        		stack.pop();
        	} else {
        		return false;
        	}
        }

        return stack.isEmpty();
    }
}
