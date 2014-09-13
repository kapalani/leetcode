import java.util.*;
import java.lang.*;
import java.io.*;

public class RemoveNthNodeFromLast{

	public static void main (String[] args) throws java.lang.Exception
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		head = removeNthFromEnd(head, 2);
		while(head!=null){
			System.out.print(head.val);
			head = head.next;
			if(head!=null)
				System.out.print("->");
		}
		
	}
	
	public static class ListNode {
		int val;	
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
 	}
 	
 	public static ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head==null)
    		return null;
    	
    	//Get the length of linked list
    	int len = 0;
    	ListNode current = head;
    	while(current!=null){
    		len += 1;
    		current = current.next;
    	}
    	
    	int a = len-n;
    	
    	//n is bigger than the length of the linked list
    	if(a<0)
    		return head;
    	//n is the head element
    	else if(a==0){
    		ListNode tmp = head.next;
    		head.next = null;
    		return tmp;
    	}
    	//Otherwise
    	current = head;
    	ListNode previous = null;
    	while(a>0){
    		previous = current;
    		current = current.next;
    		a--;
    	}
    	
    	ListNode tmp = current.next;
    	current.next = null;
    	previous.next = tmp;
    	
    	return head;
    	
    }
}
