/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// time: o(n)
// space: o(n)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if(pVal > parentVal && qVal > parentVal){
            return lowestCommonAncestor(root.right, p, q);//因为是bst所以值都大于root都在右边
        }
        else if(pVal < parentVal && qVal < parentVal){
            return lowestCommonAncestor(root.left, p, q);//值都小于root在左边
        }
        else{
            return root; //如果都没有就是root
        }
            
    }
}

//time o(n )
//space o(1)
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int pVal = p.val;
    int qVal = q.val;
    TreeNode node = root;
    while(root != null){
        if(p.val > node.val && q.val > node.val){
            node = node.right;
        }
        else if(p.val < node.val && q.val < node.val){
            node = node.left;
        }
        else{
            return node;
        }
    }
    return null;

}
