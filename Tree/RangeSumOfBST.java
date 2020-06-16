//time:o(n)
//space:o(h)

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
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        // int ans = 0;
        // Stack<TreeNode> stack = new Stack();
        // stack.push(root);
        // while (!stack.isEmpty()) {
        //     TreeNode node = stack.pop();
        //     if (node != null) {
        //         if (L <= node.val && node.val <= R)
        //             ans += node.val;
        //         if (L < node.val)
        //             stack.push(node.left);
        //         if (node.val < R)
        //             stack.push(node.right);
        //     }
        // }
        // return ans;
        if (root == null) { return 0; }
        int sum = 0;
        if (root.val > L) { sum += rangeSumBST(root.left, L, R); } // left child is a possible candidate.
        if (root.val < R) { sum += rangeSumBST(root.right, L, R); } // right child is a possible candidate.
        if (root.val >= L && root.val <= R) { sum += root.val; } // count root in.
        return sum;
    }
}