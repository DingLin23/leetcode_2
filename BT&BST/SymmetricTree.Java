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
//思路就是那一棵树的两棵左右子树拆分为两个树去做比较， 左树的左边去和右树的右边， 同样的道理左树的右边就是和右树的左边。
//time: O(n)
//space: o(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);

    }
    
    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        if (q == null) return false;
        boolean left = helper(p.left,q.right);
        boolean right = helper(p.right,q.left);
        return left && right && p.val == q.val;
    }
}