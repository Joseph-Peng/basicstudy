package lc000to050;

public class LC045_跳跃游戏2 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int end = 0;
        int step = 0;
        int maxPosition = 0;
        for(int i = 0; i < nums.length-1; ++i){
            // 找到当前范围内能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            // 遇到边界，更新下一个能跳的最远的位置
            if (i == end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    //  [2,3,1,1,4]
    public static int jump2(int[] nums) {
        if (nums.length == 0 || nums.length==1) return 0;
        int jumpTime = 0;
        int start = 0;
        while (start < nums.length-1) {
            int canReach = start + nums[start];
            jumpTime++;
            if (canReach >= nums.length-1) break;

            int i = start + 1;
            int maxCanReach = 0;
            int maxIndex = 0;
            while (i <= canReach && i < nums.length) {
                if (nums[i]+i >= maxCanReach){
                    maxIndex = i;
                    maxCanReach = nums[i] + i;
                }
                ++i;
            }
            //System.out.println(maxIndex);
            start = maxIndex;

        }
        return jumpTime;
    }

    public static int jump1(int[] nums) {
        int position = nums.length-1;
        int step = 0;
        while (position>0){
            for(int i = 0; i<position; ++i){
                if (i+nums[i]>=position){
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
}
