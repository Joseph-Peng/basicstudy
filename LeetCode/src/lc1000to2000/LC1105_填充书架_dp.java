package lc1000to2000;

import java.util.Arrays;

/**
 * @author Joseph Peng
 * @date 2023/4/23 23:08
 */
public class LC1105_填充书架_dp {

    int memo[];

    /**
     * 我们可以去掉递归中的「递」，只保留「归」的部分，即自底向上计算。
     * 通用做法：
     * 1. dfs 改成 dp 数组；
     * 2. 递归改成循环（每个参数都对应一层循环）；
     * 3. 递归边界改成 dp 数组的初始值。
     * 相当于原来是用递归去计算每个状态，现在是按照某个顺序去枚举并计算每个状态。
     * <p>
     * 本题：
     * dp[i] 都表示把 books[0] 到 books[i] 按顺序摆放后的最小高度。
     */
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        //memo = new int[books.length];
        int[] dp = new int[n + 1];
        // 初始值
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            int leftW = shelfWidth, maxH = 0;
            dp[i + 1] = Integer.MAX_VALUE;
            for (int j = i; j >= 0; --j) {
                leftW -= books[j][0];
                if (leftW < 0) break;
                maxH = Math.max(maxH, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j - 1] + maxH);
            }
        }

        return dp[n];
    }

    /**
     * 动态规划一般可以用「选或不选」以及「枚举选哪个」来思考，如果发现「选或不选」这个思路不能通过，可以试试「枚举选哪个」。
     * 一般像这种划分型 DP，通用的思路是「枚举选哪个」，即枚举第一段或者最后一段的长度，进而转换成规模更小的子问题。
     * 这里是从最后一段开始枚举，枚举j到idx这一段作为最后一层
     */
    public int dfs(int[][] books, int idx, int shelfWidth) {
        if (idx < 0) return 0;
        if (memo[idx] != -1) return memo[idx];
        int res = Integer.MAX_VALUE, maxH = 0, leftW = shelfWidth;
        for (int j = idx; j >= 0; --j) {
            // 一边枚举一边计算厚度之和（或者剩余空间），同时更新最大高度。
            leftW -= books[j][0];
            if (leftW < 0) break;
            maxH = Math.max(maxH, books[j][1]);
            res = Math.min(res, dfs(books, j - 1, shelfWidth) + maxH);
        }
        memo[idx] = res;
        return res;
    }
}
