package lc201to300;

public class LC222_完全二叉树的节点个数 {

    class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int countNodes(TreeNode root){
        if (root == null) return 0;
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right){
            //左子树高度等于右子树高度说明左子树一定是一颗满二叉树
            return (int) (countNodes(root.right) + Math.pow(2,left));
        }else{
            //左子树高度不等于右子树高度说明右子树一定是一颗满二叉树
            return (int) (countNodes(root.left) + Math.pow(2, right));
            //return countNodes(root.left) + (1<<right);
        }
    }

    private int countLevel(TreeNode root) {
        int level = 0;
        while(root!=null){
            level++;
            root = root.left;
        }
        return level;
    }

}
