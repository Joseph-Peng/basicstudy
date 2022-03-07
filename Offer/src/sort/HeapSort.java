package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {56,12,3,4,5,6,78,0,-1};
        new HeapSort().heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void heapSort(int[] nums){
        if (nums==null || nums.length==0) return;
        //1. 构建大顶堆
        buildMaxHeap(nums, nums.length);

        //2. 开始堆排序
        for(int i = nums.length-1; i>=0; --i){
            swap(nums,0,i);
            heapify(nums,0,i);
        }
    }

    private void buildMaxHeap(int[] nums, int len){
        // 从第一个非叶子节点开始处理
        for(int i = len/2;i>=0;--i){
            heapify(nums,i,len);
        }
    }

    private void heapify(int[] nums, int i, int len) {
        int left = 2*i+1;
        int right = 2*(i+1);
        int largestIndex = i;
        if (left < len && nums[largestIndex]<nums[left]){
            largestIndex = left;
        }
        if(right<len && nums[largestIndex]<nums[right]){
            largestIndex = right;
        }
        if (largestIndex!=i){
            swap(nums,i,largestIndex);
            heapify(nums,largestIndex,len);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
