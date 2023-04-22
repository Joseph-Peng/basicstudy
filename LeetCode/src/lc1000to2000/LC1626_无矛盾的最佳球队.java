package lc1000to2000;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Joseph Peng
 * @date 2023/4/21 12:52
 */
public class LC1626_无矛盾的最佳球队 {

    public static void main(String[] args) {
        int[] scores = {4,5,6,5}, ages = {2,1,2,1};
        System.out.println(bestTeamScore(scores,ages));
    }

    public static int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] people = new int[n][2];
        for (int i = 0; i < n; ++i) {
            people[i] = new int[]{scores[i], ages[i]};
        }
        // 因为采用最长递增子序列的方式来做，所以这里要将相同分数的按年龄大小排序
        // 否则people[j][1] <= people[i][1]这里就不会计算【分数相同，但是排在前面的大年纪球员了】
        Arrays.sort(people, (a, b) ->  a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            /*
            for (int j = i - 1; j >= 0; --j) {
                if (people[j][1] <= people[i][1]) {
                     //这里的问题在于,dp数组没有进行初始化，如果dp[j] + people[i][0]操作放在里面可能计算不到
                    // 就会导致某些位置的值为0，影响后续操作
                    // 解决办法是初始化dp，将排序后的score复制给dp
                    dp[i] = Math.max(dp[i], dp[j] + people[i][0]);
                }
            }
            res = Math.max(res, dp[i]);
            */
            for (int j = i - 1; j >= 0; --j) {
                if (people[j][1] <= people[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += people[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
