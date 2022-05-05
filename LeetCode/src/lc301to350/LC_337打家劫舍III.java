package lc301to350;

import java.util.HashMap;
import java.util.Map;

public class LC_337打家劫舍III {

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
    }

    public int rob(TreeNode root) {
        return dfs(root);
    }

    Map<TreeNode, Integer> memo = new HashMap<>();
    public int dfs(TreeNode root){
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);

        int money = root.val;

        if (root.left != null){
            money += dfs(root.left.left) + dfs(root.left.right);
        }

        if (root.right != null){
            money += dfs(root.right.left) + dfs(root.right.right);
        }

        int ans = Math.max(money, (dfs(root.left) + dfs(root.right)));

        memo.put(root, ans);
        return ans;
    }
}
