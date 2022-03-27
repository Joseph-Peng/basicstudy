package offer.tree;

import java.util.HashMap;
import java.util.Map;

public class Offer07_重建二叉树 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    Map<Integer, Integer> dict;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if (preorder.length == 0) return null;
        dict = new HashMap<>();
        for(int i = 0; i<inorder.length;++i){
            dict.put(inorder[i],i);
        }
        return build(preorder,0,0,inorder.length-1);
    }

    /**
     *
     * @param preorder  前序遍历数组
     * @param root      根节点
     * @param left
     * @param right
     * @return
     */
    private TreeNode build(int[] preorder, int root, int left, int right) {
        if (left>right) return null;
        TreeNode rootNode = new TreeNode(preorder[root]);
        int i = dict.get(preorder[root]);
        rootNode.left = build(preorder,root+1,left,i-1);
        rootNode.right = build(preorder, root+i-left+1,i+1,right);
        return rootNode;
    }
}
