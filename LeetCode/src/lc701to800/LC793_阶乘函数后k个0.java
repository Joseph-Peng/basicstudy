package lc701to800;

/**
 * @author Joseph Peng
 * @date 2022/8/28 21:21
 */
public class LC793_阶乘函数后k个0 {

    public int preimageSizeFZF(int k) {
        long start = 0L, end = 5L*k, mid;
        while (start <= end){
            mid = start + (end - start)/2;
            long n = 5L, nums = 0L;
            while (n <= mid){
                nums += mid/n;
                n *= 5;
            }

            if (nums == k) return 5;
            else if(nums < k) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }

}
