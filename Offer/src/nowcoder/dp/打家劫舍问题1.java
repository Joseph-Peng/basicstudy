package nowcoder.dp;

public class 打家劫舍问题1 {

    public int rob (int[] nums) {
        // 只有一个元素，就返回该元素的值
        if(nums.length == 1){
            return nums[0];
        }
        // 两个元素，就返回两元素中其中一个最大值
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        // 定义一个数组，记录 n-1个值的和 和n-2个值的和
        int[] maxVal = new int[nums.length];
        // 初始化结果数组 第0 个元素和第 1个元素
        maxVal[0] = nums[0];
        maxVal[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            maxVal[i] = Math.max(maxVal[i-1],maxVal[i-2]+nums[i]);
        }
        return maxVal[maxVal.length -1];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        // 只有一个元素，就返回该元素的值
        if(nums.length == 1){
            System.out.println(nums[0]);
            System.out.println(1);
            return;
        }
        // 定义一个数组，记录 n-1个值的和 和n-2个值的和
        int[] maxVal = new int[nums.length];
        // 初始化结果数组 第0 个元素和第 1个元素
        maxVal[0] = nums[0];
        maxVal[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            maxVal[i] = Math.max(maxVal[i-1],maxVal[i-2]+nums[i]);
        }

        int maxProfit = maxVal[nums.length-1];
        for(int i = nums.length-1; i>=0;--i){
            if (maxProfit == nums[i]){
                System.out.print(i+1);
                break;
            }
            if(i>0 && maxProfit == maxVal[i] && maxVal[i] != maxVal[i-1]){
                System.out.print(i+1 + " ");
                maxProfit -= nums[i];
            }
        }
    }

}
