public class MergeSortedLinkedList {
	
	public static void main(String[] args){
		
		ListNode head = new ListNode(4);
		head.next = new ListNode(19);
		head.next.next = new ListNode(14);
		head.next.next.next = new ListNode(5);
		
		ListNode result = sortList(head);
		while(result!=null){
			System.out.print(result.val);
			if(result.next!=null)
				System.out.print("->");
			result = result.next;
		}
	}
	
	public static ListNode sortList(ListNode head) {
		if(head==null || head.next==null)
			return head;
		int ct = 0;
		ListNode h = head;
		while(h!=null){
			ct++;
			h = h.next;
		}
		
		int mid = ct/2;
		ListNode l = head;
		ListNode r = null;
		
		ListNode p = head;
		int i=0;
		while(p != null){
			i++;
			ListNode n = p.next;
			if(i==mid){
				p.next = null;
				r = n;
			}
			p = n;
		}
		
		ListNode leftHead = sortList(l);
		ListNode rightHead = sortList(r);
		
		ListNode mergedHead = merge(leftHead, rightHead);
		
		return mergedHead;
    }
	
	public static ListNode merge(ListNode left, ListNode right){
		
		if(left==null)
			return right;
		if(right==null)
			return left;
		ListNode a = left;
		ListNode b = right;
		ListNode prev = null;
		ListNode head = null;
		
		while(a!=null && b!=null){
			if(a.val < b.val){
				if(prev==null){
					prev = a;
					head = a;
					a = a.next;
				}else {
					prev.next = a;
					prev = a;
					a = a.next;
				}
			} else if(a.val > b.val){
				if(prev==null){
					prev = b;
					head = b;
					b = b.next;
				}else {
					prev.next = b;
					prev = b;
					b = b.next;
				}
			}
		}
		
		if(a!=null)
			prev.next = a;
		else if(b!=null)
			prev.next = b;
		return head;
	}
	
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}
