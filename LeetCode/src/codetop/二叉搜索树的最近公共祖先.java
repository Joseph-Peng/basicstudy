package codetop;

import java.util.Stack;

public class 二叉搜索树的最近公共祖先 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (p.val < q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while (root!=null){
            if (root.val > p.val) root = root.left;
            else if(root.val < q.val) root = root.right;
            else break;
        }
        return root;
    }
}
