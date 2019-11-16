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
        ListNode dummy = new ListNode(0);
        int sum = 0;
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);//如果大于10，留余数，如果小于10取原数
            sum /= 10;//carring the 1 to the next number.
            cur = cur.next;
        }
        if (sum == 1) { //if the last two add pair has number greater than 10
            cur.next = new ListNode(1); // carring the 1 to the next new ndoe
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("sss");
    }
}
