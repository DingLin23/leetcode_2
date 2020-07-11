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
// bottom up 
// time : o(n)
// time :o (n)
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }
    
    private boolean helper(TreeNode root, int sum) {
        if (root == null) return false; 
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        boolean left = helper(root.left, sum - root.val);
        boolean right = helper(root.right,sum - root.val);
        return left || right;
    }
}