package codetop;

import java.util.Arrays;

public class 数组中出现次数超过三分之一的元素 {

    public static void main(String[] args) {
        int nums[] = {1,1,1,1,1,2,2,4,3,3};
        System.out.println(Arrays.toString(majorElement(nums)));
    }

    public static int[] majorElement(int[] nums){
        int m = 0,n = 0;
        int cm = 0,cn = 0;
        for(int num : nums){
            if (cm == 0 || num == m){
                m = num;
                ++cm;
            }else if (cn==0 || num==n){
                n = num;
                ++cn;
            }else {
                --cn;
                --cm;
            }
        }

        cm = 0;
        cn = 0;
        for(int num : nums){
            if (num==m) cm++;
            if (num==n) cn++;
        }

        m = cm>=nums.length/3? m:0;
        n = cn>=nums.length/3? n:0;

        return new int[]{m,n};
    }
}
