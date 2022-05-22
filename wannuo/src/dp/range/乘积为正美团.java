package dp.range;

public class 乘积为正美团 {

    public static void main(String[] args) {
        int[] nums = {1,-1,-1,1,1};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){
        // 1 -1 -1 1
        int ans = 0;
        boolean[][] dp = new boolean[nums.length][nums.length];

        for(int j = 0; j<nums.length; ++j){
            for(int i = j; i>=0; --i){
                if (i == j) dp[i][j] = nums[i]>0;
                else if(i+1 == j) dp[i][j] = nums[i]*nums[j] > 0;
                else dp[i][j] = (nums[i]*nums[j]* (dp[i+1][j-1] ? 1:-1))>0;
                if (dp[i][j]) ans++;
            }
        }

        return ans;
    }
}
