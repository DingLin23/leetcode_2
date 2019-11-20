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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        
        while(!queue.isEmpty()){
            TreeNode l = queue.poll();
            TreeNode r = queue.poll();
            
            if(l == null && r == null) continue;
            else if(l == null || r == null || l.val != r.val) return false;
            
            queue.add(l.left);
            queue.add(r.left);
            queue.add(l.right);
            queue.add(r.right);
        }
        return true;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if(p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}