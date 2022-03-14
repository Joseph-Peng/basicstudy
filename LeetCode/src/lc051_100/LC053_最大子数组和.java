package lc051_100;

public class LC053_最大子数组和 {

    public int maxSubArray(int[] nums){
        int p = 0;
        int res = Integer.MIN_VALUE;
        for (int num : nums){
            if (p>0) p+=num;
            else p = num;
            res = Math.max(res,p);
        }
        return res;
    }
}
