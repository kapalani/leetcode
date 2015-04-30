import java.util.Stack;

public class SimplifyUnixPath {
	public static void main (String[] args) {
		String path = "/home/../home/";
		String result = simplifyPath(path);
		System.out.println(result);
	}

	public static String simplifyPath(String path) {
        if (path == null) return null;
        
        Stack<String> stack = new Stack<String>();
        String[] list = path.split("/");
        for (int i=0; i<list.length; i++) {
        	if (list[i].equals(".") || list[i].length() == 0 ) continue;
        	else if (!list[i].equals("..")) {
        		stack.push(list[i]);
        	} else {
        		if (!stack.isEmpty())
        			stack.pop();
        	}
        }
        
        Stack<String> temp = new Stack<String>();
        while(!stack.isEmpty()) {
        	temp.push(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        while(!temp.isEmpty()) {
        	sb.append("/" + temp.pop());
        }
        
        if (sb.length() == 0)
        	return "/";
        
        return sb.toString();
    }
}
