package lc051_100;

import java.util.Arrays;

public class LC55_跳跃游戏 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
        System.out.println(canJump2(nums));
    }

    public static boolean canJump(int[] nums) {
        int maxPosition = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > maxPosition) return false;
            maxPosition = Math.max(maxPosition, nums[i] + i);
        }
        return true;
    }

    public static boolean canJump2(int[] nums) {
        if(nums.length == 1) return true;
        memory = new int[nums.length];
        Arrays.fill(memory, -1);
        return dfs(0,nums);
    }

    static int[] memory;
    public static boolean dfs(int idx, int[] nums){
        if(memory[idx] != -1) return memory[idx] == 1;
        boolean ans = false;
        if(idx + nums[idx] >= nums.length - 1){
            ans = true;
        }

        for(int i = 1; i<=nums[idx] && !ans; ++i){
            ans = dfs(idx+i,nums);
        }
        memory[idx] = ans ? 1 : 0;
        return ans;
    }
}
