package lc501to550;

public class LC543_二叉树的直径 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        recur(root);
        return res - 1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        int right = recur(root.right);
        res = Math.max(res,left+right+1);
        return Math.max(left,right) + 1;
    }
}
