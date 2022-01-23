package lc000to050;

import java.util.Arrays;

public class LC16_最接近的三数之和 {

    public static void main(String[] args) {
        LC16_最接近的三数之和 test = new LC16_最接近的三数之和();
        int[] nums = {-3,-2,-5,3,-4};
        System.out.println(test.threeSumClosest(nums,-1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 1000000;
        // 1. 三指针
        for(int i = 0; i<nums.length; ++i){
            if(i>0 && nums[i] == nums[i-1]) continue;
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) return target;
                if(Math.abs(sum-target) < Math.abs(best-target)){
                    best = sum;
                }
                if(sum < target){
                    while (j<k && nums[j] == nums[j+1]) ++j;
                    ++j;
                }else{
                    while (j<k && nums[k] == nums[k-1]) --k;
                    --k;
                }
            }
        }
        return best;
    }
}
