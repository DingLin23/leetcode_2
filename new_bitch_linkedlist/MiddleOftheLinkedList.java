/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode temp = head;
        int count = 0;
        
        while(head != null){
            head = head.next;
            count++;
        }
        
        for(int i = 0; i < count/2; i++){
            temp = temp.next;
        }
        return temp;
        
    }
}