package lc000to050;

public class LC004_寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int totalLen = len1 + len2;
        int midIndex = totalLen / 2;
        if (totalLen % 2 == 0) {
            double mid = (getKthElement(nums1, nums2, midIndex) +
                    getKthElement(nums1, nums2, midIndex + 1)) / 2.0;
            return mid;
        } else {
            double mid = getKthElement(nums1, nums2, midIndex + 1);
            return mid;
        }
    }

    private int getKthElement(int[] nums1, int[] nums2, int k) {
        /*
         要查找第k大的元素，那么将两个数组的第 k/2 -1个元素进行比较
         pivot1 = nums1[k/2-1]   pivot2 = nums2[k/2-1]
         nums1中小于pivot1的数的个数为  k/2-1
         nums2中小于pivot2的数的个数为  k/2-1
         取 pivot = min(pivot1, pivot2)
         所以两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         pivot 本身最大也只能是第 k-1 小的元素(注意数组下标从0开始)
         如果 pivot = pivot1
         那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         如果 pivot = pivot2
         那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值
         ，减去删除的数的个数
         当k=1时说明已经排除了前k-1个元素，所以只需要返回min(nums1[index1],nums2[index2])
         */
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            // 边界情况
            // 1. nums1 比对到头了
            if (index1 >= len1) {
                return nums2[index2 + k - 1];
            }
            // 2. nums2 比对到头了
            if (index2 >= len2) {
                return nums1[index1 + k - 1];
            }
            // 3. k==1
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            //正常情况
            int half = k / 2;
            int newIndex1 = Math.min(len1, index1 + half) - 1;
            int newIndex2 = Math.min(len2, index2 + half) - 1;
            if (nums1[newIndex1] < nums2[newIndex2]) {
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            } else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }
}
