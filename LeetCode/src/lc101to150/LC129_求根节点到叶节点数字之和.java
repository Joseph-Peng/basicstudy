package lc101to150;

public class LC129_求根节点到叶节点数字之和 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int sumNumbers(TreeNode root) {
        return recur(root,0);
    }

    private int recur(TreeNode root, int i) {
        if (root == null) return 0;
        int temp = i*10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return recur(root.left,temp) + recur(root.right,temp);
    }

}
