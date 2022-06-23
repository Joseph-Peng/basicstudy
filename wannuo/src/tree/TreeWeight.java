package tree;

import java.time.temporal.Temporal;
import java.util.*;

public class TreeWeight {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tree = sc.nextLine().split(" ");
        int[][] ops = {{2,4},{1,2}};

        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        buildTree(root, 0, tree);

        treeWeight(root, ops);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            res.add(node.val);
        }
        System.out.println(res);
    }

    public static TreeNode treeWeight(TreeNode node, int[][] ops){
        int[] weights = new int[100010];
        for(int[] op : ops){
            weights[op[0]] ^= op[1];
        }
        dfs(node, 0, weights);
        return node;
    }

    private static void dfs(TreeNode node, int wei, int[] weights){
        if (node == null) return;
        node.val = wei^weights[node.val];
        dfs(node.left, node.val, weights);
        dfs(node.right, node.val, weights);
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
