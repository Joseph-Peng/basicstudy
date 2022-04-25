package backtrace;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC698_划分为k个相等的子集 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) sum += num;
        if (sum %k != 0) return false;
        Arrays.sort(nums);
        int[] bts = new int[k];
        backtrace(nums.length-1, bts,nums,k,sum/k);
        return flag;
    }

    public boolean flag = false;

    public void backtrace(int idx, int[] bts, int[] nums, int k, int target){
        if (idx < 0 || flag){
            flag = true;
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i<bts.length; ++i){
            if (flag) return;
            if (nums[idx] + bts[i] > target || set.contains(bts[i])) continue;
            set.add(bts[i]);
            bts[i] += nums[idx];
            backtrace(idx-1,bts,nums,k,target);
            bts[i] -= nums[idx];
        }
    }
}
