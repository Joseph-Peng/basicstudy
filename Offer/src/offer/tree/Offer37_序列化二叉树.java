package offer.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Offer37_序列化二叉树 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuffer res = new StringBuffer();
        res.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){
                res.append("null,");
            }else{
                res.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String nodes[] = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!nodes[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(left);
                node.left = left;
            }
            ++i;

            if(!nodes[i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(right);
                node.right = right;
            }
            ++i;
        }

        return root;
    }
}
