public class LC1143_最长公共子序列 {

    /*
    给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。
    如果不存在 公共子序列 ，返回 0 。
     */

    /*
    两个字符串一般使用二维dp
    dp[i][j]表示text1.charAt(i)、text2.charAt(j)的情况下的最长公共子序列
    dp[0][0] = 0
    dp[i][0] = 0
    dp[j][0] = 0

                           dp[i-1][j-1] + 1    text1.charAt(i) == text2.charAt(j)
    状态转移方程 dp[i][j] =
                           max(dp[i-1][j], dp[i][j-1])   text1.charAt(i) != text2.charAt(j)
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1;i<=len1;++i){
            for (int j = 1; j<=len2;j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
