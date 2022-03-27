package offer.tree;

public class Offer26_树的子结构 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B){
        if (A==null || B==null) return false;
        return recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B==null) return true;
        if (A==null || A.val!=B.val) return false;
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}
