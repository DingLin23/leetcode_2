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
// time: o(n)
//spcae:o(n)
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
           return 0;
       }
        //如果左边为空的话，那就要让右边+1，因为求的是min，最后要左右比较。
       if (root.left == null) {
           return minDepth(root.right) + 1;
       }
        //同理
       if (root.right == null) {
           return minDepth(root.left) + 1;
       }
       int left = minDepth(root.left);
       int right = minDepth(root.right);
       return Math.min(left, right) + 1;
    }
}