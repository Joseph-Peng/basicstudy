package offer;

public class Offer53_II0到n减1中缺失的数字 {

    // 0 1 2 3 5 6 7 8
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
