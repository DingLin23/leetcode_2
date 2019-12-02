/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//time:O(nlogk);
//space: O (N)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //corner case
        if(lists == null || lists.length == 0) return null;

        //create priorityQueue
        Queue<ListNode> pq = new PriorityQueue<>(Lists.length, (a,b) -> (a.val - b.val));

        //adding each head of list into pq
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) pq.offer(lists[i]);
        }

        //compare
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!pq.isEmpty()){
            ListNode head = pq.poll();
            tail.next = head;
            tail = head;
            if(head.next != null) pq.offer(head.next);
        }

        return dummy.next;
    }
}
// 1->4->5
// 1->3->4
// 2->6
    
//    4->5
// 1->3->4
// I 2->6
// res: 1

//    4->5
//    3->4
//    2->6
// res: 1->1
    
//    4->5
//    3->4
//       6
// res: 1->1->2
    

