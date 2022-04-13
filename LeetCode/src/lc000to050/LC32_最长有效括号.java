package lc000to050;

public class LC32_最长有效括号 {

    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); ++i) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i>=2? dp[i-2]:0) + 2;
                }else if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1] + 2;
                    if(i-dp[i-1]>=2){
                        dp[i] += dp[i-dp[i-1]-2];
                    }
                }
                maxLen = Math.max(maxLen,dp[i]);
            }
        }
        return maxLen;
    }

}
