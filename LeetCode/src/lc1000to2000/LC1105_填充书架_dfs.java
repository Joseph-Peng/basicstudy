package lc1000to2000;

import java.util.Arrays;

/**
 * @author Joseph Peng
 * @date 2023/4/23 23:08
 */
public class LC1105_填充书架_dfs {

    int memo[];

    public int minHeightShelves(int[][] books, int shelfWidth) {
        memo = new int[books.length];
        Arrays.fill(memo, -1);
        return dfs(books, books.length - 1, shelfWidth);
    }

    /**
     动态规划一般可以用「选或不选」以及「枚举选哪个」来思考，如果发现「选或不选」这个思路不能通过，可以试试「枚举选哪个」。
     一般像这种划分型 DP，通用的思路是「枚举选哪个」，即枚举第一段或者最后一段的长度，进而转换成规模更小的子问题。
     这里是从最后一段开始枚举，枚举j到idx这一段作为最后一层
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
            res = Math.min(res, dfs(books,j - 1, shelfWidth) + maxH);
        }
        memo[idx] = res;
        return res;
    }
}
