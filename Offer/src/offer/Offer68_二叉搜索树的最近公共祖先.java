package offer;

public class Offer68_二叉搜索树的最近公共祖先 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        TreeNode t = p;
        if (p.val > q.val) {
            p = q;
            q = t;
        }
        // 迭代
        t = root;
        while (t != null) {
            if (t.val > q.val) {
                t = t.left;
            } else if (t.val < p.val) {
                t = t.right;
            }else {
                break;
            }
        }
        return t;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val>p.val && root.val>q.val){
            return lowestCommonAncestor1(root.left,p,q);
        }
        if (root.val<p.val && root.val<q.val){
            return lowestCommonAncestor1(root.right,p,q);
        }
        return root;
    }
}
