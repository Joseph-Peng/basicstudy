package codetop;

public class 二叉树中相距最远的节点的距离 {
    class TreeNode{
        int lMax;
        int rMax;
        TreeNode left;
        TreeNode right;
    }

    public int maxLen = 0;

    public void findMaxDistance(TreeNode root){
        if (root == null) return;

        // 如果左子树为空，那么该节点的左边最长距离为0
        if (root.left == null) root.lMax = 0;

        // 如果右子树为空，那么该节点的右边最长距离为0
        if (root.right == null) root.rMax = 0;

        // 如果左子树不为空，递归寻找左子树最长距离
        if (root.left!=null){
            findMaxDistance(root.left);
        }

        // 如果右子树不为空，递归寻找右子树最长距离
        if (root.right != null){
            findMaxDistance(root.right);
        }

        // 计算左子树最长节点距离
        if (root.left != null){
            root.lMax = root.left.lMax > root.left.rMax ?
                    (root.left.lMax + 1): (root.left.rMax + 1);
        }
        // 计算右子树最长节点距离
        if (root.right != null){
            root.rMax = root.right.lMax > root.right.rMax ?
                    (root.right.lMax + 1): (root.right.rMax + 1);
        }

        // 更新最长距离
        if((root.lMax + root.rMax) > maxLen)
        {
            maxLen = root.lMax + root.rMax;
        }

    }
}
