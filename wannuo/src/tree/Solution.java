package tree;

import java.util.*;

public class Solution {

    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(TreeNode left, TreeNode right, int val){
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }



    /*public static void buildTree(TreeNode root, int idx, String[] nodes){
        int left = 2*idx + 1;
        int right = 2*idx + 2;
        if(left < nodes.length && !nodes[left].equals("0")){
            TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[left]));
            root.left = leftNode;
            buildTree(leftNode, left, nodes);
        }
        if(right < nodes.length && !nodes[right].equals("0")){
            TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[right]));
            root.right = rightNode;
            buildTree(rightNode, right, nodes);
        }

    }*/

    static TreeNode target = null;
    static int direction = 0;
    public static void dfs(TreeNode root, TreeNode parent,StringBuffer path, String pattern, int flag){
        StringBuffer temp = new StringBuffer(path);
        if(root == null) return;
        temp.append("/" + root.val);
        if (temp.equals(pattern)){
            target = parent;
            direction = flag;
            return;
        }
        if(root.left != null){
            dfs(root.left, root, temp, pattern, 1);
        }

        if (root.right != null){
            dfs(root.right, root, temp, pattern, 2);
        }
    }


    public static void buildTree(TreeNode root, int idx, String[] nodes){
        int left = 2*idx + 1;
        int right = 2*idx + 2;
        if(left < nodes.length && !nodes[left].equals("0")){
            TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[left]));
            root.left = leftNode;
            buildTree(leftNode, left, nodes);
        }
        if(right < nodes.length && !nodes[right].equals("0")){
            TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[right]));
            root.right = rightNode;
            buildTree(rightNode, right, nodes);
        }

    }

}
