package linkedlist;

public class IntersectionPointOfTwoLinkedLists {
	public static void main(String[] args) {
		
		ListNode connectingNode = new ListNode(10);
		connectingNode.next = new ListNode(12);
		
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(5);
		node1.next.next = connectingNode;

		ListNode node2 = new ListNode(3);
		node2.next =  new ListNode(4);
		node2.next.next = new ListNode(6);
		node2.next.next.next = connectingNode;
		
		ListNode result = getIntersectionNode(node1, node2);
		if (result != null)
			System.out.println(result.val);
		else 
			System.out.println("null");
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode currentA = headA;
        ListNode currentB = headB;
        
        int lenA = 0;
        int lenB = 0;
        
        while(currentA != null) {
        	lenA++;
        	currentA = currentA.next;
        }
        
        while(currentB != null) {
        	lenB++;
        	currentB = currentB.next;
        }
        
        if (lenA > lenB) {
        	int diff = lenA - lenB;
        	for (int i = 0; i < diff; i++) {
        		headA = headA.next;
        	}
        } else if (lenA < lenB) {
        	int diff = lenB - lenA;
        	for (int i = 0; i < diff; i++) {
        		headB = headB.next;
        	}
        } 
        
        while(headA !=null && headB !=null) {
        	if (headA.val == headB.val) 
        		return headA;
        	else {
        		headA = headA.next;
        		headB = headB.next;
        	}
        }
        return null;
    }
}
