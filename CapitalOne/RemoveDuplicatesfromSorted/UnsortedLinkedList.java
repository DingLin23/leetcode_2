//Remove duplicates from sorted linked list :

//time:o(n)
//space:o(1)
class Solution{
public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode (0);
        dummy.next = head;
        ListNode cur = dummy.next;
        
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur.next = cur.next.next;
                
            }
            cur = cur.next;
            
        }
        return dummy.next;
}
//Remove duplicates from unsorted linked list (works on sorted list as well) :


//time:o(n)
//spaca:o(n)
public ListNode deleteDuplicates(ListNode head) {
    Set<Integer> set = new HashSet<>();
    ListNode pre = null;
    ListNode fakeHead = head;
    while(fakeHead != null){
        if(!set.add(fakeHead.val)){
            pre.next = fakeHead.next;
        } else{
            pre = fakeHead;
        }
        fakeHead = fakeHead.next;
    }
    return head;
}
}