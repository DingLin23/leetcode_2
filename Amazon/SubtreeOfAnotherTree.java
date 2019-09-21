//time:o(m*n) m is # of nodes of s, n is # of nodes of t.
//space:o(h) h is the height of s.

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if (isSametree(s,t)) return true;
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    private boolean isSametree(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
 
        if (s.val != t.val) return false;
        return isSametree(s.left,t.left) && isSametree(s.right,t.right);
    }
}