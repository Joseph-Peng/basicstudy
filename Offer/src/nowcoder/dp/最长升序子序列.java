package nowcoder.dp;

import java.util.Arrays;

public class 最长升序子序列 {

    public int LIS (int[] arr) {
        if (arr.length == 0) return 0;
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);
        int maxLen = 1;
        for(int i = 0; i<arr.length; ++i){
            for(int j = 0; j<i; j++){
                if (arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen = Math.max(dp[i],maxLen);
        }
        return maxLen;
    }
}
