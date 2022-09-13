package lc501to700;

import java.util.*;

/**
 * @author Joseph Peng
 * @date 2022/9/5 9:09
 */
public class LC652_寻找重复的子树 {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }

    Map<String, TreeNode> seen = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(repeat);
    }

    public String dfs(TreeNode root){
        if(root == null){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        sb.append("(");
        sb.append(dfs(root.left));
        sb.append(")(");
        sb.append(dfs(root.right));
        sb.append("(");
        String serial = sb.toString();
        if (seen.containsKey(serial)){
            repeat.add(seen.get(serial));
        }else {
            seen.put(serial, root);
        }
        return serial;
    }
}
