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
// height of tree starts from 0, so -1 is free to use as a flag
//1.bottom up solution:time:o(n) space:o(n) in my solution
// however u can do level from top to bottom which will give nlgn time complexity
//because height will be called on each node log(n) times.

class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        if (Math.abs(left - right) > 1 || left == -1 || right == -1) return -1;
        return Math.max(left, right) + 1;
    }

}