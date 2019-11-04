import java.util.HashMap;

import org.w3c.dom.Node;

//LeetCode 138
//time:o(n)
//space:o(n)

class Solution {
    public Node copyRandomList(Node head){
        // corner case
        if(head == null) return null;

        HashMap<Node, Node> map = new HashMap<> ();
        Node cur = head;

        //copy
        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        //referenc
        cur = head; // because cur will be null at this point, u need to let cur back to head;

        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head); // why head because cur is null ; u need to return the whole node.

    }
}