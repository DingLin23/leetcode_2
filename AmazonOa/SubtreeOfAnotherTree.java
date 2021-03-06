/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Complexity Analysis

// Time complexity : 
// O(m∗n) time.
// Here n nodes are present in given tree s and m nodes are present in given tree t.

// Space complexity : 
// O(n). The depth of the recursion tree can go upto n. 
// n refers to the number of nodes in s.

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
    // corner case s == null false
    // check s and t are exactly same tree or not
    // if not check s.left ot s.right compare with t. recusively.
    // if found s.left or s.right == t.val. check both child is null or not.
    // then if not both case, check val is equal or not.
    // recusively check s.right and t.right, s.left and t.left.
        
        if(s == null) return false;// main tree checking
        if (isSameTree(s,t)) return true;//check if both are exactly same tree.
        return isSubtree(s.left,t) || isSubtree(s.right,t); // if not same tree, go the s's child to check
  
    }
    private boolean isSameTree(TreeNode s,TreeNode t){
        if(s == null && t == null) return true;// check if both dont have child 
        if(s == null || t == null) return false;// check if either one has chil
        if(s.val != t.val) return false; // check both value equal or not.
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }
}