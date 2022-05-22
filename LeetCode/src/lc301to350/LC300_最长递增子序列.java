package lc301to350;

import java.util.Arrays;

public class LC300_最长递增子序列 {

    // dp[i] 表示以nums[i]结尾的数的最长递增子序列的长度
    public int lengthOfLIS2(int[] nums) {
        int maxLen = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 0; i < nums.length; ++i){
            for(int j = 0; j<i; ++j){
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] > maxLen){
                maxLen = dp[i];
            }
        }
        return maxLen;
    }

    // dp[i] 表示以长度为i的递增子序列的最后一个数
    //   1 7 7 7 2 6 8
    //   1
    //   1 7               maxLen = 2
    //   1 7
    public int lengthOfLIS(int[] nums) {
        int maxLen = 0;
        int[] dp = new int[nums.length];
        for(int num : nums){
            int i = 0, j = maxLen;
            while (i < j){
                int mid = i + (j-i)/2;
                if(dp[mid] < num) i = mid + 1;
                else j = mid;
            }
            dp[i] = num;
            // j == maxLen 说明当前j没有移动过，说明所有的数都小于num
            if (j == maxLen) maxLen++;
        }
        return maxLen;
    }

    // 返回最长升序子序列
    public static int[] LIS (int[] arr) {
        int maxLen = 0;
        int[] dp = new int[arr.length];
        int[] index = new int[arr.length];
        for(int idx = 0; idx<arr.length; ++idx){
            int i = 0, j = maxLen;
            while (i < j){
                int mid = i + (j-i)/2;
                if(dp[mid] < arr[idx]) i = mid + 1;
                else j = mid;
            }
            dp[i] = arr[idx];
            index[idx] = i + 1;
            // j == maxLen 说明当前j没有移动过，说明所有的数都小于num
            if (j == maxLen) maxLen++;
        }
        int[] res = new int[maxLen];
        for(int i = arr.length-1; i>=0 && maxLen > 0; --i){
            if (index[i] == maxLen){
                res[maxLen - 1] = arr[i];
                maxLen--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,3,6,4,8,9,7};
        System.out.println(Arrays.toString(LIS(arr)));
    }
}
