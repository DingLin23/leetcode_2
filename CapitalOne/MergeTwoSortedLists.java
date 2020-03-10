/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//time : O(n+m)
//space: O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = new ListNode(l1.val);// intial a node val u have to that way
                l1 = l1.next;                                      
            }else{
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null) cur.next = l1;// if only left l1 != null cur.next add l1; //if either one is null, return the other one.
        if(l2 != null) cur.next = l2;// if only left l2 != null cur.next add l2;
        
        return dummy.next;  //included if both l1,l2 are null case.     
    }

   // recursive way
        //time:o(n+m); space:o(n+m)
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}