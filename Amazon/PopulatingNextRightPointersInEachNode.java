/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
// time: O(N)
//SPACE:O(1)
class Solution {
    public Node connect(Node root) {
        return helper(root, null);
    }
    private Node helper(Node cur, Node r){
        if(cur == null) return null;
        cur.next = r;
        cur.left = helper(cur.left,cur.right);
        cur.right = (r == null)?  helper(cur.right,null) : helper(cur.right,r.left);
        return cur;
    }
}