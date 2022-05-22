package dp.linear;

public class 最长公共子串 {

    public static void main(String[] args) {
        System.out.println(solution("hellooworld","loop"));
    }

    public static String solution(String s1, String s2){
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxLen = 0, start = 0, end = 0;

        for(int i = 1; i<=len1; ++i){
            for(int j = 1; j<=len2; ++j){
                if (s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                if (dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                    start = j-maxLen;
                }
            }
        }
        System.out.println(maxLen);
        return s2.substring(start, start+maxLen);
    }
}
