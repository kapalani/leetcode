public class MergeSortedLinkedLists{

    public static void main(String []args){
       ListNode rootA = new ListNode(1);
       rootA.next = new ListNode(3);
       ListNode rootB = new ListNode(2);
       ListNode head = mergeTwoLists(rootA, rootB);
       
        while(head!=null){
            System.out.print(head.val);
            if(head.next!=null)
                System.out.print("->");
            head = head.next;
        }
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        ListNode a = l1;
        ListNode b = l2;
        ListNode prev = null;
        ListNode head = null;
        
        while(a!=null && b!=null){
            if(a.val<b.val){
                if(prev==null){
                    head = a;
                    prev = a;
                    a = a.next;
                }else {
                    prev.next = a;
                    prev = a;
                    a = a.next;
                }
            }else {
                if(prev==null){
                    head = b;
                    prev = b;
                    b = b.next;
                }else {
                    prev.next = b;
                    prev = b;
                    b = b.next;
                }
            }
        }
        
        if(a!=null){
            prev.next = a;
        }
        
        else if(b!=null){
            prev.next = b;
        }
        
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}