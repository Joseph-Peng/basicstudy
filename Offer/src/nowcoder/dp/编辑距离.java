package nowcoder.dp;

public class 编辑距离 {

    /*
    经典的动态规划解法，记dp[i][j]表示将str10~i编辑成str20~j的代价，
    如果str1i=str2j，那么dp[i][j]就可以直接从dp[i-1][j-1]转移过来，
    否则就比较插入、删除和替换三种操作哪种的代价小：
    1.如果str1(0~i-1)已经编辑成了str2(0~j-1)，只需要将str1(i)替换为str2(j)可以完成转换，
      代价为dp[i-1][j-1]+rc
    2.如果str1(0~i-1)已经被编辑为str2(0~j)，只需要将str1(0~i)删除一个str1(i)就可以完成转换，
      代价为dp[i-1][j]+dc
    3.如果str1(0~i)已经被编辑为str2(0~j-1)，只需要插入一个str2(j)就可以完成转换，
      代价为dp[i][j-1]+ic
     */
    public int editDistance(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; ++i) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; ++i) {
            dp[0][i] = i;
        }

        // 自底向上求解
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[len1][len2];
    }
}
