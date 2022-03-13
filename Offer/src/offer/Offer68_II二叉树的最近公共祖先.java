package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer68_II二叉树的最近公共祖先 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 递归解法
    //若 root 是 p, q 的 最近公共祖先 ，则只可能为以下情况之一：
    //1. p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
    //2. p=root ，且 q 在 root 的左或右子树中；
    //3. q=root ，且 p 在 root 的左或右子树中；

    // 先序遍历，指底向上返回
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right==null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }



    // 使用List记录从根节点出发到节点p的路径的集合
    // 从头开始比对两个节点路径的集合，最后一个相同的节点就是最近的公共祖先
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pathP = new LinkedList<>();
        LinkedList<TreeNode> pathQ = new LinkedList<>();
        getPath(root, pathP, p);
        getPath(root, pathQ, q);
        TreeNode res = null;
        int n = Math.min(pathP.size(), pathQ.size());
        for (int i = 0; i < n; ++i) {
            if (pathP.get(i) == pathQ.get(i)) res = pathP.get(i);
        }
        return res;
    }

    private void getPath(TreeNode root, LinkedList<TreeNode> path, TreeNode node) {
        if (root == null) return;
        path.addLast(root);
        if (root == node) return;
        //可以再这里判断是否已经遍历到了node，进行剪枝
        //if (path.get(path.size()-1)!=node)
        getPath(root.left, path, node);
        //if (path.get(path.size()-1)!=node)
        getPath(root.right, path, node);
        if (path.get(path.size() - 1) != node) {
            path.removeLast();
        }
    }

}
