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
		connect(root,null); //base case level 0
        return root;
	}
    private void connect(Node root1, Node root2){
        if(root1 == null) return;
        root1.next = root2;
        connect(root1.left,root1.right); // base case 2 level 1
        if(root2 != null){ //after level 1.
            connect(root1.right, root2.left);
            connect(root2.left,root2.right);
        }
    }
}