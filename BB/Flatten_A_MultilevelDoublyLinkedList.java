//time:O(n)
//space:O(N)

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = head;
        while(cur != null){
            if(cur.child != null){ //如果没有小孩，就到下一个node。如果有小孩，当下NODE的next放进stack
               if(cur.next != null){
                   stack.push(cur.next);
                }
                cur.next = cur.child; // 让child变成cur的下个指针指向的node，
                cur.next.prev = cur;// child node指回cur.
                cur.child = null;//变child的状态为null
            }
            else if(cur.next == null && !stack.isEmpty()){ //当已经排完所有的child到最后一个cur.next 为null的时候，开始lifo POP出stack里面的值。
                    cur.next = stack.pop();
                    cur.next.prev = cur; //指回去，因为双向指针。
                
            }
            cur = cur.next;//当前下跳。
        }  
        return head;
    }
}