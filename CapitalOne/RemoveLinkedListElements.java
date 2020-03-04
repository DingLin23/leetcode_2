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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        head.next  = removeElements(head.next, val);
        return head.val == val ? head.next : head;

    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);// have to have dummy, cause what if head.val = val.
    dummy.next = head;
    ListNode prev = dummy;

   while (head != null) {

     if (head.val == val) {
       prev.next = head.next;
     } else {
       prev = head;
     }
     head = head.next;
   }

   return dummy.next;

    }
}



