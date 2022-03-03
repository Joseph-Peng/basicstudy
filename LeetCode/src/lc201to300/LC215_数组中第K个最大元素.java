package lc201to300;

import java.util.Random;

public class LC215_数组中第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        int i = low, j = high;
        int randomIndex = new Random().nextInt(high - low + 1) + low;
        swap(nums, low, randomIndex);
        int temp = nums[low];
        while (i < j) {
            while (i < j && nums[j] >= temp) --j;
            while (i < j && nums[i] <= temp) ++i;
            swap(nums, i, j);
        }
        swap(nums, i, low);
        if (i > k) {
            return quickSelect(nums, low, i - 1, k);
        } else if (i < k) {
            return quickSelect(nums, i + 1, high, k);
        }
        return nums[i];
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
