package dp.range;

import java.util.HashMap;
import java.util.Map;

public class 区间权值之和 {

    public static void main(String[] args) {
        int nums[] = {10,2,5};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int len = nums.length;
        int[][] dp2 = new int[len][len];
        int[][] dp5 = new int[len][len];
        int cnt = 0;
        for (int j = 0; j < len; ++j) {
            for (int i = j; i >= 0; --i) {
                if(i==j){
                    dp2[i][j] = get2(nums[i]);
                    dp5[i][j] = get5(nums[i]);
                }else if(i+1 == j){
                    dp2[i][j] = get2(nums[i]) + get2(nums[j]);
                    dp5[i][j] = get5(nums[i]) + get5(nums[j]);
                }else{
                    dp2[i][j] = get2(nums[i]) + get2(nums[j]) + dp2[i+1][j-1];
                    dp5[i][j] = get5(nums[i]) + get5(nums[j]) + dp5[i+1][j-1];
                }
                cnt += Math.min(dp2[i][j], dp5[i][j]);
            }
        }
        return cnt;
    }

    static Map<Integer, Integer> map2 = new HashMap<>();
    static Map<Integer, Integer> map5 = new HashMap<>();

    public static int get2(int x) {
        if (map2.containsKey(x)) return map2.get(x);
        int res = 0;
        int tmp = x;
        while (x != 0 && x % 2 == 0) {
            res++;
            x /= 2;
        }
        map2.put(tmp, res);
        return res;
    }

    public static int get5(int x) {
        if (map5.containsKey(x)) return map5.get(x);
        int res = 0;
        int tmp = x;
        while (x != 0 && x % 5 == 0) {
            res++;
            x /= 5;
        }
        map5.put(tmp, res);
        return res;
    }
}
