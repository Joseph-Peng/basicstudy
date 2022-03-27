package offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32_II从上到下打印二叉树II {

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
        if(root!=null) queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i<size;i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
