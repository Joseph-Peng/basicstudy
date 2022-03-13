package lc000to050;

public class LC010_正则表达式匹配 {

    /*      a  b  .  *
        T   F  F  F  F
    a   F   T  F  F  F
    b   F   F  T  F  T
    c   F   F  F  T  T
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean dp[][] = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        // dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配

        for (int i = 0; i <= sLen; ++i) {
            for (int j = 1; j <= pLen; ++j) {
                if (p.charAt(j - 1) == '*') {
                    if (j > 1 && dp[i][j - 2]) {  // 看做0次匹配,例如就是a*，不出现，a出现0次
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        if (i > 0 && j > 1) {
                            // 0次匹配不行，那么就判断'*' 前面那个字符，能匹配 s[i]，或者 '*' 前面那个字符是万能的'.'
                            // 则dp[i][j] = d[i-1][j];(因为*可以表示0个、1个或多个)
                            if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                                dp[i][j] = dp[i - 1][j];
                            }
                        }
                    }
                } else {
                    if (i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[sLen][pLen];
    }
}
