/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//time: o(n)
//space: o(n)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        int sum = 0;
        while(p1 != null || p2 != null){
            if(p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            
            cur.next = new ListNode(sum%10); // if sum < 10 just get sum, > 10 take the 0;
            sum /= 10; //if sum > 10 take the reminder to next one, otherwise reset sum = 0;
           cur = cur.next;
        }
        if(sum == 1){// checking the last number is great than 10 or not
            cur.next = new ListNode(1);        
        }
        return dummy.next;
    }
}