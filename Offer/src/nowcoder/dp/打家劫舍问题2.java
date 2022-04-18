package nowcoder.dp;

public class 打家劫舍问题2 {

    public int rob (int[] nums) {
        // 只有一个元素，就返回该元素的值
        if(nums.length == 1){
            return nums[0];
        }
        // 两个元素，就返回两元素中其中一个最大值
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        // 偷第一家
        int first = nums[0], second = nums[0];
        for(int i = 2; i < nums.length; ++i){
            int temp = second;
            second = Math.max(first+nums[i], second);
            first = temp;
        }
        // 由于偷第一家，就不能偷最后一家
        int profit1 = first;

        // 不偷第一家
        first = 0;
        second = nums[1];
        for(int i = 2; i < nums.length;++i){
            int temp = second;
            second = Math.max(second,first+nums[i]);
            first = temp;
        }
        return Math.max(profit1,second);
    }
}
