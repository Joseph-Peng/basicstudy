package lc000to050;

import java.util.HashMap;
import java.util.Map;

public class LC045_跳跃游戏2_记搜 {

    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        return dfs(0,nums);
    }
    public static Map<Integer,Integer> map = new HashMap<>();

    public static int dfs(int idx, int[] nums){
        if (idx >= nums.length - 1) return 0;
        if (map.containsKey(idx)) return map.get(idx);

        int ans = nums.length+2;
        for (int i = 1; i<=nums[idx]; ++i){
            ans = Math.min(ans, dfs(idx+i,nums) + 1);
        }
        map.put(idx,ans);
        return ans;
    }


}
