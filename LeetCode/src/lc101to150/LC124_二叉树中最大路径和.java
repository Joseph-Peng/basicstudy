package lc101to150;

public class LC124_二叉树中最大路径和 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return maxSum;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(postOrder(root.left),0);
        int right = Math.max(postOrder(root.right),0);

        int totalSum = left + right + root.val;
        maxSum = Math.max(totalSum,maxSum);

        return root.val + Math.max(left,right);
    }
}
