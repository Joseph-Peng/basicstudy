package lc;

public class No4 {

    public static void main(String[] args) {
        int[] nums = {2,1,4,3,5};
        System.out.println(countSubarrays(nums, 10));
    }

    public static long countSubarrays(int[] nums, long k) {
        // 前缀和，统计数组每一段的和
        long prefix[] = new long[nums.length + 1];
        prefix[0] = 0;
        long p = 0;
        for(int i = 0; i < nums.length; ++i){
            p +=  nums[i];
            prefix[i+1] = p;
        }
        long cnt = 0;
        int left = 0, right = 0;
        while (right < nums.length){
            long multi = (long)(prefix[right+1] - prefix[left]) * (long)(right-left + 1);
            if(multi < k){
                right++;
                int len = right - left;
                cnt += len;
            }else {
                left++;
            }
        }
        return cnt;
    }
}

