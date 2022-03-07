package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {56,12,3,4,5,6,78,0,-1};
        new QuickSort().quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] nums, int low, int high){
        if (low<high){
            int i = low, j = high;
            int temp = nums[i];
            while (i<j){
                while (i<j && nums[j]>=temp) --j;
                while (i<j && nums[i]<=temp) ++i;
                swap(nums,i,j);
            }
            swap(nums,i,low);
            quickSort(nums,low,i-1);
            quickSort(nums,i+1,high);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
