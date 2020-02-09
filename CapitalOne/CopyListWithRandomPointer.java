class Solution{

    //time:o(n)
    //space:o(n)
    public Node CopyRandomList(Node head){
        if(head == null) return null;
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while(cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }

        // cur need to point back to head;
        cur = head;

        //making connection inorder to have deeep copy
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}