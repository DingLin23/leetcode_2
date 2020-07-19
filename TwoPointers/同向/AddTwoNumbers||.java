/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.offerFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.offerFirst(l2.val);
            l2 = l2.next;
        }
        
        ListNode cur = null, prev = null; int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int val1 = !stack1.isEmpty()? stack1.pollFirst() : 0;
            int val2 = !stack2.isEmpty()? stack2.pollFirst() : 0;
            int sum = val1 + val2 + carry;
            carry = sum/10;
            cur = new ListNode(sum%10);
            cur.next = prev;
            prev = cur;
        }
        return cur;
    }
}