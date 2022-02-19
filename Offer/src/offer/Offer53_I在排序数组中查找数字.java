package offer;

public class Offer53_I在排序数组中查找数字 {

    public static void main(String[] args) {
        int nums[] = {1, 3, 3, 3, 3};
        System.out.println(binarySearch(nums, 3));
        System.out.println(binarySearch2(nums, 3));
    }

    // 统计一个数字在排序数组中出现的次数。
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int right = i;
        if (right == 0 || nums[right - 1] != target) return 0;
        i = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }

    // 找到排序数组中第一个比target大的数字
    private static int binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        //这边是“小于等于”，因此当循环结束后，ij不重合，
        // 1.如果target存在，那么找到target后i会+1，直到i大于j
        //
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }

    // 找到排序数组中第一个比target大的数字
    private static int binarySearch2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return j;
    }
}
