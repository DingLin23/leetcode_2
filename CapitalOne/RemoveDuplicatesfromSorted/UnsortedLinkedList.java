//Remove duplicates from sorted linked list :

//time:o(n)
//space:o(1)
class Solution{
public ListNode deleteDuplicates(ListNode head) {
    ListNode fakeHead = head;
    while(fakeHead != null && fakeHead.next != null){
        if(fakeHead.val == fakeHead.next.val){
            fakeHead.next = fakeHead.next.next;
        } else{
            fakeHead = fakeHead.next;
        }
    }
    return head;
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