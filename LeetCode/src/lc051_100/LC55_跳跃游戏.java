package lc051_100;

public class LC55_跳跃游戏 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int maxPosition = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > maxPosition) return false;
            maxPosition = Math.max(maxPosition, nums[i] + i);
        }
        return true;
    }
}
