package lc401to450;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC416_分割等和子集 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum%2!=0) return false;
        Arrays.sort(nums);
        backTrace(nums.length-1,new int[2],sum/2,nums);
        return flag;
    }

    public boolean flag = false;
    // 参数：idx、两个桶bts
    public void backTrace(int idx, int[] bts, int target, int nums[]){
        // 出口，都能放入桶内，说明可以划分为两个相等的子集
        if (idx < 0 || flag){
            flag = true;
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<2; ++i){
            if(flag) return;
            // 剪枝，如果已经有相同值的桶被尝试过了，就continue
            if(nums[idx] + bts[i] > target || set.contains(bts[i])) continue;
            set.add(bts[i]);
            bts[i] += nums[idx];
            backTrace(idx-1, bts, target, nums);
            bts[i] -= nums[idx];
        }
    }
}
