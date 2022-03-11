package codetop;

import java.util.Arrays;

public class 消失的两个数字1到N缺两个数 {

    public static void main(String[] args) {
        int[] nums = {2, 4};
        System.out.println(Arrays.toString(missingTwoNum(nums)));
        System.out.println(Arrays.toString(missingTwoNum1(nums)));
    }

    /*
    给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？

    以任意顺序返回这两个数字均可。

    示例 1:

    输入: [1]
    输出: [2,3]
    示例 2:

    输入: [2,3]
    输出: [1,4]
    提示：
    数组可能是乱序
    nums.length <= 30000

     */

    // 1. 位运算
    // 先把数组中所有的元素做异或，再把和1-N做异或，
    // 那么得到的数就是缺失的两个数的异或diff，找到两个数异或中第一个不为0的二进制位mask
    // 再和数组元素和1-N中mask位为1的数做异或，就可以得到其中的一个数
    // 在和diff做异或，就能得到第二个数
    public static int[] missingTwoNum(int[] nums) {
        // 1. 异或的方式将两个数分开
        int N = nums.length + 2;
        int diff = 0;
        for (int i = 1; i <= N; ++i) {
            diff ^= i;
        }
        for (int i = 0; i < nums.length; ++i) {
            diff ^= nums[i];
        }

        //找到diff中最右边第一个不为1的二进制位
        int mask = 1;
        while ((mask & diff) == 0) {
            mask <<= 1;
        }

        // 通过mask分开数组
        int one = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((mask & nums[i]) != 0) one ^= nums[i];
        }

        for (int i = 1; i <= N; ++i) {
            if ((mask & i) != 0) one ^= i;
        }
        return new int[]{one, one ^ diff};
    }

    // 分组求和
    public static int[] missingTwoNum1(int[] nums) {
        // 1-N的和减去数组的和然后除以2，就能求到缺失的两个数one和two的平均数
        int N = nums.length + 2;
        int sumN = 0, sumNum = 0;
        for (int i = 1; i <= N; ++i) {
            sumN += i;
        }
        for (int i = 0; i < nums.length; ++i) {
            sumNum += nums[i];
        }

        int sumTwo = sumN-sumNum;
        int diff = sumTwo/2;
        //针对 N 和sum两个数组，小于等diff的分别分为一组；
        // 大于diff的分别分为一组；那么两个组的差值即为缺失的一大一小
        int sumNumLess = 0;
        for (int num : nums){
            if (num<=diff) sumNumLess+=num;
        }
        int sumNLess = 0;
        for(int i =1;i<=N;++i){
            if (i<=diff) sumNLess+=i;
        }
        int one = sumNLess-sumNumLess;
        int two = sumTwo-one;
        return new int[]{one,two};
    }
}
