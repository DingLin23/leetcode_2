/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//time:O(n)
//space:O(n)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, 0 , res);
        return res;
    }
    private void helper(TreeNode root, int level, List<List<Integer>>res){
        if(root == null) return;
        if(res.size()<=level){
            res.add(new ArrayList<>());
        }
        List<Integer> collection = res.get(level); // 拿到当前的所在的level
        
        if(level % 2 == 0) res.get(level).add(root.val); // % 2 == 0 的时候都是先加左子树
        else{
        collection.add(0,root.val);//先加左子树，但是当奇数层的右子树进来的时候，因为还在排在0的位置上，原先的左子树的位置向后移。
            System.out.print(collection);
        }
        helper(root.left,level+1,res);
        helper(root.right,level+1,res);
        
    }
}