/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//time: o(n)
//space:o(1)
class Solution {
    public boolean isValidBST(TreeNode root) {
       return help(root,null,null);
    }
    private boolean help(TreeNode p, Integer low, Integer high) {
    if (p == null) return true;
    return (low == null || p.val > low) && (high == null || p.val < high) && help(p.left, low, p.val) && help(p.right, p.val, high);
}


//time: o(n)
//space:o(n)
public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
       while (root != null) {
          stack.push(root);
          root = root.left;
       }
       root = stack.pop();
       if(pre != null && root.val <= pre.val) return false;
       pre = root;
       root = root.right;
    }
    return true;
 }
}