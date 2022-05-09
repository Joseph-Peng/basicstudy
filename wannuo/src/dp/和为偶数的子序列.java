package dp;

public class 和为偶数的子序列 {

    public static void main(String[] args) {
        solution(5,2, new int[]{1,2,3,4,5});
        solution(3,1, new int[]{1,2,3});
        solution(4,3, new int[]{1,4,2,2});
    }

    /*
    式子：f(i,j,k) = f(i-1, j, k) + f(i-1,(j+nums[i])%2, k-1)
    base case：f(0,0,0) = 1; 便于往后推导
    规模：i->n, j->2, k->len
    填表顺序：i->n, j->2, k->len
     */
    public static void solution(int n, int len, int[] nums){
        int[][][] dp = new int[n+1][2][len+1];
        dp[0][0][0] = 1;
        for(int i = 1; i<=n; ++i){
            for(int j = 0; j<2; ++j){
                for(int k = 0; k<=len; ++k){
                    if (k==0) dp[i][j][k] = dp[i-1][j][k];
                    else dp[i][j][k] = dp[i-1][j][k] + dp[i-1][(j+nums[i-1])%2][k-1];
                }
            }
        }
        System.out.println(dp[n][0][len]);
    }
}
