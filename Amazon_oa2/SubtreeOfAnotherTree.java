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
//time: O(m*n) in worst case traverse function takes O(m*n) time;
//space: O(n) the depth of TreeNode s;
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)  return false;
        if(isSameTree(s,t)) return true;
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }
}