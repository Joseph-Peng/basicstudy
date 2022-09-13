package lc501to700;

public class LC516_最长回文子序列 {

    public static int longestPalindromeSubseq(String s) {

        if(s == null) return 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        int maxLen = 0;
        for(int j = 0; j<len; ++j){
            for(int i = j; i>=0; --i){
                if(i==j) dp[i][j] = 1;
                else if(i+1 == j) dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                else dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i+1][j-1] + 2 : dp[i][j-1];

                if(dp[i][j] > maxLen) maxLen = dp[i][j];
            }
        }
        return maxLen;

    }

    public static void main(String[] args) {
        int res = longestPalindromeSubseq("aabcba");
        System.out.println(res);
    }
}
