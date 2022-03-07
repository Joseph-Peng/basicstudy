package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {56, 12, 3, 4, 5, 6, 78, 0, -1};
        new MergeSort().mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left == right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums,left,mid,right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right-left+1];
        int i = left, j = mid+1;
        int k = 0;
        while (i<=mid && j<=right){
            if (nums[i]>nums[j]){
                temp[k++] = nums[j++];
            }else {
                temp[k++] = nums[i++];
            }
        }
        while (i<=mid){
            temp[k++] = nums[i++];
        }
        while (j<=right){
            temp[k++] = nums[j++];
        }
        for (i = left; i<=right;++i){
            nums[i] = temp[i-left];
        }
    }
}
