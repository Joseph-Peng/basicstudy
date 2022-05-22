package dp.range;

public class LC05_最长的回文子串 {

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0, start = 0;

        for(int j = 0; j<len; ++j){
            for(int i = j; i>=0; --i){
                if (i==j) dp[i][j] = true;
                else if(i+1 == j) dp[i][j] = s.charAt(i) == s.charAt(j);
                else dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];

                if (dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
