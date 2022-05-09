package lc401to450;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC416_分割等和子集 {

    // 使用回溯超时，需要使用dp
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        Arrays.sort(nums);
        backTrace(nums.length - 1, new int[2], sum / 2, nums);
        return flag;
    }

    public boolean flag = false;

    // 参数：idx、两个桶bts
    public void backTrace(int idx, int[] bts, int target, int nums[]) {
        // 出口，都能放入桶内，说明可以划分为两个相等的子集
        if (idx < 0 || flag) {
            flag = true;
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 2; ++i) {
            if (flag) return;
            // 剪枝，如果已经有相同值的桶被尝试过了，就continue
            if (nums[idx] + bts[i] > target || set.contains(bts[i])) continue;
            set.add(bts[i]);
            bts[i] += nums[idx];
            backTrace(idx - 1, bts, target, nums);
            bts[i] -= nums[idx];
        }
    }

    /*
    一个数字两种状态选和不选，每个数字只能选一次，01背包
    式子：f(i,j) = f(i-1,j) || f(i-1,j-nums[i]);   // i为数组index，j为target
    base case：第0行(0,j) --> f(0,0) = true;  其他都为false
    规模：i最大为nums.length, j最大为sum/2
    填表顺序：一行一行填
     */
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        for(int i = 1; i <= nums.length; ++i){
            for(int j = 0; j<=target;++j){
                if (j >= nums[i-1]) dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nums.length][target];
    }

    /*
    滚动数组: 0-1背包反向
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int i = 1; i <= nums.length; ++i){
            for(int j = target; j>= nums[i-1]; --j){
                dp[j] = dp[j] || dp[j-nums[i-1]];
            }
        }
        return dp[target];
    }
}
