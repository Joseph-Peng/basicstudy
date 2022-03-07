package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {56,12,3,4,5,6,78,0,-1};
        new BubbleSort().bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void bubbleSort(int[] nums){
        if (nums == null || nums.length==0) return;
        for(int i = 0; i<nums.length-1;++i){
            boolean flag = false;
            for(int j = 0; j<nums.length-i-1;++j){
                if (nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }
}
