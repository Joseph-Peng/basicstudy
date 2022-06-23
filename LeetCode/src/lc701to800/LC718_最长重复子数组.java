package lc701to800;

public class LC718_最长重复子数组 {

    // dp[i][j]表示以nums1[i]和nums2[j]结尾的最长重复子数组的长度
    // dp[i][j] = nums1[i] == nums2[j] ? dp[i-1][j-1] : 0;
    // base case: 0
    public static int findLength(int[] nums1, int[] nums2) {
        int maxLen = 0;
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                dp[i][j] = nums1[i-1] == nums2[j-1] ? (dp[i-1][j-1] + 1) : 0;
                maxLen = Math.max(dp[i][j], maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};

        System.out.println(findLength(nums1, nums2));
    }
}
