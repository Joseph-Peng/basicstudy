package lc101to150;

import java.util.HashMap;
import java.util.Map;

public class LC106_从中序和后序构建二叉树 {

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LC106_从中序和后序构建二叉树 test = new LC106_从中序和后序构建二叉树();
        int[] inorder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
        test.buildTree(inorder, postOrder);
    }

    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; ++i){
            map.put(inorder[i], i);
        }
        return build(postorder.length - 1, postorder, 0, inorder.length - 1);
    }

    public TreeNode build(int rootIndex, int[] postorder, int l, int r){
        if(l > r) return null;
        int val = postorder[rootIndex];
        TreeNode root = new TreeNode(val);
        int i = map.get(val);
        System.out.println(i);
        root.left = build(rootIndex - (r - i + 1), postorder, l, i-1);
        root.right = build(rootIndex - 1, postorder, i+1, r);

        return root;
    }
}
