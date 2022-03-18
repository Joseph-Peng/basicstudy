package nowcoder.tree;

import java.util.HashMap;
import java.util.Map;

public class 重建二叉树 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    Map<Integer,Integer> dict = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        if (pre.length ==0 || vin.length == 0) return null;
        for (int i = 0; i<vin.length;++i){
            dict.put(vin[i],i);
        }
        return build(pre,0,0,vin.length-1);
    }

    private TreeNode build(int[] pre, int root, int left, int right) {
        if (left>right) return null;
        TreeNode head = new TreeNode(pre[root]);
        int i = dict.get(pre[root]);
        head.left = build(pre, root+1, left, i-1);
        head.right = build(pre,root+i-left+1, i+1, right);
        return head;
    }
}
