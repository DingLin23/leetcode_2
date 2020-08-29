//time: O(n)
//spcae: o(n)

class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        
        //case1: 如果root的值小于L,就说明要裁左子树，所以输出右子树继续剪裁
        if (root.val < L) return trimBST(root.right, L, R);
        //case2: 如果root的值大于r,就说明要裁右子树，所以输出左子树继续剪裁
        if (root.val > R) return trimBST(root.left, L, R);
        
        //case3: 如果 L <= value <= R 
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        
        return root;
    }
}