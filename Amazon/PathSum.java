/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;// to detect root is null or giving an option for later excuting if either one of root.left and root.right is null.
        if(root.left == null && root.right == null) return sum == root.val;
        //checking when u hitting each path to the end.
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val); // excuting the one is true; 
    }
}