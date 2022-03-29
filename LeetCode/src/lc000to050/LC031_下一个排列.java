package lc000to050;

public class LC031_下一个排列 {

    /*
    首先我们需要将左边较小的数与一个右边较大的数交换，同时这个较小的数尽量靠右，而较大的数尽量小
    1. 从尾部向前找(i,j)找到第一个 a[i]<a[j]的数，此时这个数就是尽量靠左的较小的数
    2. 由于我们上一步向前走的条件是a[i]<a[j]所以 [j,nums.length-1]一定是降序排序
    3. 我们在[j,nums.length-1]中找到一个比a[i]大，又尽量靠右的数，那么就可以使用二分查找
    4. 将查找的数与a[i]交换，然后再将[j,nums.length-1]逆序，就是下一个排列
    **/
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for (; i >= 0 && nums[i] >= nums[i + 1]; --i) ;
        if (i >= 0) {
            int j = binarySearch(nums, nums[i], i + 1, nums.length - 1);
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int nums[], int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public int binarySearch(int nums[], int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
