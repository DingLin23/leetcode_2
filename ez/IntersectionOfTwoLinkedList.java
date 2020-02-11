/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 //time: o(n)
 //space:o(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        //Actually we don't care about the "value" of difference, we just want to make sure two pointers reach the intersection node at the same time.
        
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
    }
}