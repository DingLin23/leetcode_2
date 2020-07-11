/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//time: O(n)
//space:O(n)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;// 这个先为递归出口就错了。因为如果两棵树都为空的话，是对的答案。
        
        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
}