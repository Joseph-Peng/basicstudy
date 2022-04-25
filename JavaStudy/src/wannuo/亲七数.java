package wannuo;

import java.util.HashSet;
import java.util.Set;

public class 亲七数 {

    public static void main(String[] args) {
        int nums[] = {1,1,2};
        System.out.println(seven(nums));
    }

    public static int res = 0;
    public static int seven(int[] nums){
        int count = 0;
        backTrace(nums,0);
        return res;
    }

    private static void backTrace(int[] nums, int d) {
        if (d == nums.length-1){
            int digit = 0;
            for(int i = 0; i<nums.length;++i){
                digit = digit*10 + nums[i];
            }
            // System.out.println(digit);
            if (digit%7 == 0) res++;
            return;
        }

        for(int i = d; i<nums.length;++i){
            swap(nums,d,i);
            backTrace(nums,d+1);
            swap(nums,d,i);
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
