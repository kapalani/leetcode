public class ReorderLinkedList {
	public static void main(String[] args){
		ListNode head = new ListNode(4);
		head.next = new ListNode(19);
		head.next.next = new ListNode(14);
		head.next.next.next = new ListNode(5);
		reorderList(head);
		
	}
	
	public static void reorderList(ListNode head){
		if(head==null || head.next == null)
			return;
		
		ListNode slow = head;
		ListNode fast = head;

		while(slow!=null && fast!=null && fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//Reverse the second half of the linked list
		ListNode prev = null;
		ListNode tmp = slow.next;
		while(tmp!=null){
			ListNode next = tmp.next;
			tmp.next = prev;
			prev = tmp;
			tmp = next;
		}
		
		//Making left linked list
		slow.next = null;
		
		//Right linked list
		ListNode rHead = prev;
		
		//Go through elements in each left and right lists and append left - > right
		ListNode left = head;
		ListNode right = rHead;
		while(left!=null && right!=null){
			ListNode l = left.next;
			ListNode r = right.next;
			left.next = right;
			right.next = l;
			left = l;
			right = r;
		}
	
		while(head!=null){
			System.out.print(head.val);
			if(head.next!=null)
				System.out.print("->");
			head = head.next;
		}
	}
}
