
//time: O(n)
//space: o(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i<size; i++){
                TreeNode cur = queue.poll();
                System.out.println(cur.val);
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!= null) queue.offer(cur.right);
                list.add(cur.val);
            }
            res.add(list);
        }
        return res;
        }
}