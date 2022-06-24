package lc000to050;

import java.util.Arrays;

public class LC41_缺失的第一个正数 {

    public static void main(String[] args) {
        int[] nums = {3,4,-1, 1};
        System.out.println(firstMissingPositive(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        int len = nums.length;
        while(i < len){
            while(nums[i] > 0 && nums[i] <= len && nums[nums[i]-1] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }
            i++;
        }
        for(i = 0; i < len; ++i){
            if(nums[i] != i+1) return i + 1;
        }
        return i+1;
    }
}
