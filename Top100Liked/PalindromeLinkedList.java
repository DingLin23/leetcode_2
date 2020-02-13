/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//time: o(n)
//space:o(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    //               s     f
    // we have 1->3->2->3->1
        
    // if (fast != null) { // odd nodes: let right half smaller
    //     slow = slow.next;
    // }
  
     //        f     s     
    // we have 1->3->2->3->1              
    slow = reverse(slow);
    fast = head;
    
        
     //        f         
    // we have 1->3->2->3->1
             //s
             //1->3->2->null
    while (slow != null) {
        if (fast.val != slow.val) {
            return false;
        }
        fast = fast.next;
        slow = slow.next;
    }
    return true;
}
    
    // 2->3->1->null
    // into
    //1->3->2->null
public ListNode reverse(ListNode head) { 
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;   // 1.next = 3 ; 2. next = 1 3. next = null
        head.next = prev; // 1.2 ->null; 2. 3->2->null; 3. 1->3->2->null
        prev = head; // 1.prev = 2 ; 2.prev = 3; 3. prev = 1;
        head = next; //1. head = 3 ; 2. head = 1; 3. head = null
    }
    return prev; 
    }
}