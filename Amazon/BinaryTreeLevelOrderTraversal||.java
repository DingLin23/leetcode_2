/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //time:/O(n)
 //space:O(n)
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                list.add(cur.val);
                 
            }
            res.add(0,list);//所有的反向都可以用这个方法。
        }
        return res;
    }
    
    //time:O(n)
    //space:O(1)
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) return res;
            helper(root, 0 , res);
            return res;
        }
        
        private void helper(TreeNode root, int level, List<List<Integer>> res){
            if(root == null) return;
            if(res.size() <= level){
                res.add(0, new ArrayList<>());
            }
            
            helper(root.left, level+1, res);
            helper(root.right, level+1, res);
            res.get(res.size()-(level+1)).add(root.val);// after to the last level. we need to add the last level root.val into the first level;
        }
    }
    
    

