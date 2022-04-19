package codetop;

public class 补充题圆环回原点问题 {

    public int GetSteps(int n,int step){
        int[][] dp=new int[step+1][n];
        dp[0][0]=1;
        for(int i=1;i<=step;i++){
            for(int j=0;j<n;j++){
                // dp[i] [j]  ,  表示 走 i 步 回到 j 点有多少种走法
                dp[i][j]=dp[i-1][(j-1+n)%n]+dp[i-1][(j+1+n)%n];
            }
        }
        return dp[step][0];
    }
}
