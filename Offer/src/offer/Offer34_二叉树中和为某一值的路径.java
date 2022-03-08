package offer;

import java.util.ArrayList;
import java.util.List;

public class Offer34_二叉树中和为某一值的路径 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target){
        if (root==null) return res;
        List<Integer> path = new ArrayList<>();
        dfs(root,0,target,path);
        return res;
    }

    private void dfs(TreeNode root, int sum, int target, List<Integer> path) {
        //终止条件
        if (root==null) return;
        sum+=root.val;
        path.add(root.val);
        if (root.left==null && root.right==null && sum == target){
                res.add(new ArrayList<>(path));
        }
        //做选择
        dfs(root.left,sum,target,path);
        dfs(root.right,sum,target,path);
        //撤销选择
        path.remove(path.size()-1);
    }


}
