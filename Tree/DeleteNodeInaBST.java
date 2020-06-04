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
// 1.algo: if tree not contains key value return tree itself;
//         if find the key, we need to delete it, if the key node doesnt have left child we return right child.  if doesnt have right child we return left child.  if have both child, either go to all the ways of left subtree.right or all the way of right subtree.left. find the node to replace the delete node. but we also need to delete the duplcate one. just recusive call original function with start from the subtree and the value.
//time: o(height)
//space: o(height)    
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)  return null;
        
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                TreeNode min = findMin(root.left);
                root.val = min.val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
        
    }
    
    private TreeNode findMin(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}