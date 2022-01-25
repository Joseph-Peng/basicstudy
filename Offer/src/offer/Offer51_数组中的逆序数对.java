package offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class Offer51_数组中的逆序数对 {

    public static void main(String[] args) {
        Offer51_数组中的逆序数对 test = new Offer51_数组中的逆序数对();
        int nums[] = {7,5,6,4};
        System.out.println(test.reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        return mergeSort(0,nums.length-1, nums);
    }

    private int mergeSort(int low, int high, int[] nums) {
        int count = 0;
        if(low>=high) return count;

        int mid = low+(high-low)/2;
        int leftPairs = mergeSort(low,mid,nums);
        int rightPairs = mergeSort(mid+1,high,nums);
        int i = low;
        int j = mid+1;
        int[] temp = new int[high-low+1];
        int k = 0;
        while (i<=mid || j<=high){
            if(i==mid+1){
                temp[k++] = nums[j++];
            }else if(j==high+1 || nums[i]<=nums[j]){
                temp[k++] = nums[i++];
            }else {
                count += mid-i+1;
                temp[k++] = nums[j++];
            }
        }
        for (i = 0; i<k; ++i){
            nums[low+i] = temp[i];
        }
        return leftPairs+rightPairs+count;
    }

}


