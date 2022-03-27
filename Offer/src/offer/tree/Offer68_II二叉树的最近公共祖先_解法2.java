package offer.tree;

import java.util.*;

public class Offer68_II二叉树的最近公共祖先_解法2 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    Map<TreeNode,TreeNode> parent = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    // 使用Map存储二叉树节点的父节点
    // 将p到root的路径存入set中
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       dfs(root);
       while (p!=null){
           set.add(p.val);
           p = parent.get(p);
       }
       while (q!=null){
           if (set.contains(q.val)) return q;
           q = parent.get(q);
       }
       return null;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left!=null){
            parent.put(root.left,root);
            dfs(root.left);
        }

        if (root.right!=null){
            parent.put(root.right,root);
            dfs(root.right);
        }
    }

}
