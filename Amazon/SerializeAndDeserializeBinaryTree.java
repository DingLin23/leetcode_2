/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //time:o(n)
 //space:o(n)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //corner case
        if(root == null) return "";
        //BFS-queue
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder s = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null) s.append("null");
            else{
                s.append(cur.val);
                q.offer(cur.left);
                q.offer(cur.right);
            }
            s.append(",");
        }
        s.deleteCharAt(s.length()-1);
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //corner case
        if(data == "") return null;
        //split string by ","
        String [] s = data.split(",");
        
        //queue,not empty
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        q.offer(root);
        
        //1.create treenode;2.connect to parent node;3.add to queue
        for(int i = 1; i < s.length; i++){
            TreeNode parent = q.poll();
            if(!s[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(s[i]));
                parent.left = left;
                q.offer(left);
            }
            if(!s[++i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(s[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));