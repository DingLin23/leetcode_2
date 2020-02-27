public class AddTwoNumbers {
    /**

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8

     time : O(n)
     space : O(n)

     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode (0); // dummy in order to return from the beginning node
        ListNode cur = dummy; // a pointer to traverse
        int sum = 0;
        ListNode p1 = l1, p2 = l2;
        while(p1 != null || p2 != null){
            if(p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum%10); //if sum < 10, if > 10 cur.next is the remainder.
            sum /= 10; // if sum < 10, sum update to 0, else taking the carries 1.
            cur = cur.next;
        }
        // if the last sum is > 10;
        if(sum == 1){
            cur.next = new ListNode(1);
        }
         return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("sss");
    }
}
