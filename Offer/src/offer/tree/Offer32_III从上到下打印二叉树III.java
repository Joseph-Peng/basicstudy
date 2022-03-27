package offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32_III从上到下打印二叉树III {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ this.val = x;}
    }

    /**
     * 之字形顺序打印二叉树
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null) queue.offer(root);
        while (!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i<size; ++i){
                TreeNode node = queue.poll();
                if (res.size()%2==0) temp.add(node.val);
                else temp.addFirst(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
