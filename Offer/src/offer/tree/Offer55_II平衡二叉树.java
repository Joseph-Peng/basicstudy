package offer.tree;

public class Offer55_II平衡二叉树 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    // 后续遍历 后序遍历 + 剪枝 （从底至顶）
    // 对二叉树做后序遍历，从底至顶返回子树深度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
    public boolean isBalanced(TreeNode root) {
        return recur(root)!=-1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        if (left == -1) return -1;
        int right = depth(root.right);
        if (right == -1) return -1;
        return Math.abs(left-right)>1? -1 : Math.max(left,right) + 1;
    }

    // 先序遍历 + 判断深度 （从顶至底） N*Log(N)的时间复杂度
    public boolean isBalanced1(TreeNode root) {
        if (root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left-right)<=1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    public int depth(TreeNode node){
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
