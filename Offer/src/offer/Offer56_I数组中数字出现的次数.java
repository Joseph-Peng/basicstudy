package offer;

import java.util.Arrays;

public class Offer56_I数组中数字出现的次数 {

    public static void main(String[] args) {
        int nums[] = {1,1,2,2,3,4,4,6,6,7,7,8,8,9,9,10};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }

    public static int[] singleNumbers(int[] nums) {
        int temp = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            temp ^= nums[i];
        }
        // 找到temp的二进制形式中右边第一个为1的位数
        int div = 1;
        while ((div & temp) == 0) {
            div <<= 1;
        }
        int x = 0, y = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((nums[i] & div) == 0) x ^= nums[i];
            else y ^= nums[i];
        }
        return new int[]{x,y};
    }
}
