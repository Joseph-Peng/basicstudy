package sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {56,12,3,4,5,6,78,0,-1};
        new InsertSort().insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void insertSort(int[] nums){
        for(int i = 0; i<nums.length;++i){
            for (int j = i; j>0;--j){
                if (nums[j]<nums[j-1]){
                    swap(nums,j,j-1);
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
