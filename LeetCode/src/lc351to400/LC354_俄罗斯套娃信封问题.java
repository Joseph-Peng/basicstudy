package lc351to400;

import java.util.Arrays;
import java.util.Comparator;

public class LC354_俄罗斯套娃信封问题 {

    public int maxEnvelopes(int[][] envelops){
        if (envelops==null || envelops.length==0) return 0;
        //对数组进行排序，信封长w升序排列，对于w相同的，使用信封高度h逆序排序
        // 然后在对h度的这一列求其最长递增子数组的长度，就是结果。
        // 对高度进行逆序排序，这样能保证w相同的信封不会被计算进去
        Arrays.sort(envelops, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
                if (a1[0] == a2[0]){
                    return a2[1]-a1[1];
                }
                return a1[0] - a2[0];
            }
        });
        int dp[] = new int[envelops.length];
        Arrays.fill(dp,1);
        int max = 1;
        for (int i = 1; i < envelops.length;++i){
            for (int j = 0;j<i;++j){
                if (envelops[i][1]>envelops[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;

    }
}
