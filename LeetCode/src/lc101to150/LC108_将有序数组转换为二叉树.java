package lc101to150;

public class LC108_将有序数组转换为二叉树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return midBuild(nums, 0, nums.length - 1);
    }

    private TreeNode midBuild(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = midBuild(nums, low, mid - 1);
        root.right = midBuild(nums, mid + 1, high);

        return root;
    }
}
