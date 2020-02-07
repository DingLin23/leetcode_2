/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 //time:o(n)
 //space:O(1)
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
		return head;
	    }
        
        ListNode odd = head;
        ListNode eHead = head.next; //need to get back to head.next adding back to last odd node.
        ListNode even = eHead;
        while(even != null && even.next != null){
            odd.next = even.next; // 1->3  
            odd = odd.next; // odd point to 3
            even.next = odd.next; //2->4
            even = even.next;  // even point 4
            
        }
        odd.next = eHead;// final add even starting point back to odd.next.
        return head;
	
    }
}