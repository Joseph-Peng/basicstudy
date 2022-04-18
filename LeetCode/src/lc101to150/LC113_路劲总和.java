package lc101to150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC113_路劲总和 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){

        }

        TreeNode(int x){
            this.val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        backTrace(root, res, path, targetSum);
        return res;
    }

    private void backTrace(TreeNode root, List<List<Integer>> res, LinkedList<Integer> path, int targetSum) {
        if (root == null) return;
        targetSum -= root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && targetSum == 0){
            res.add(new ArrayList<>(path));
        }

        backTrace(root.left, res,path,targetSum);
        backTrace(root.right, res,path,targetSum);

        path.removeLast();
    }
}
