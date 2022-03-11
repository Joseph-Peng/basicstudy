package offer;

public class Offer42_连续子数组的最大和 {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int p = 0;
        for (int num : nums) {
            if (p>0) p+=num;
            else p = num;
            max = Math.max(p,max);
        }
        return max;
    }
}
