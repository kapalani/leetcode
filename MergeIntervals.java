import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;


public class MergeIntervals {
	public static void main(String[] args) {
		Interval one = new Interval(1, 4);
		Interval two = new Interval(0, 4);
		
		List<Interval> list = new ArrayList<Interval>();
		list.add(one);
		list.add(two);
		
		List<Interval> result = merge(list);
		for (Interval a: result) {
			System.out.print("{" + a.start + "," + a.end + "}");
		}
		
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        
        if(intervals == null || intervals.size() == 0) return list;
        
        if (intervals.size() == 1) return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
		});
        
        Stack<Interval> stack = new Stack<Interval>();
        stack.push(intervals.get(0));
        
        for (int i=1; i<intervals.size(); i++) {
        	if (stack.peek().end >= intervals.get(i).start) {
        		if (stack.peek().end < intervals.get(i).end)
        			stack.peek().end = intervals.get(i).end;
        		
        	} else {
        		stack.push(intervals.get(i));
        	}
        }
        while(!stack.isEmpty()) {
        	list.add(stack.pop());
        }
        
        return list;
    }
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
