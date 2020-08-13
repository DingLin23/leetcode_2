/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//time: o(n)
//space: o(n)
class Solution {
    public Node copyRandomList(Node head) {
        //corner case 
        if (head == null) return null;
        
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        //[cur1,7],[cur2,13],[cur3,11].... 
        //make a copy
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        
        cur = head;
        
        //make a connection, .next,.random 连接起来
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        
        return map.get(head);
    }
}