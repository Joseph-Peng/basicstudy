package lc201to300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC279_完全平方数 {

    public static void main(String[] args) {
        LC279_完全平方数 test = new LC279_完全平方数();
        System.out.println(test.numSquares(12));
    }

    public int numSquares2(int n) {
        int a = (int) Math.sqrt(n);
        if (a*a == n) return 1;
        int[] squares = getSquares(n);
        /*
        转化为凑成和为n的最短子集
        式子：f(i,j) = min(f(i-1, j), f(i, j-squares[i]) + 1)
        base case：f(0,0) = 0; f(0,i) = n+1;
        规模：i->squares.length; j->n
        填表顺序：一行一行填
         */
        int[][] dp = new int[squares.length+1][n+1];
        Arrays.fill(dp[0], n);
        dp[0][0] = 0;
        for(int i = 1;i <= squares.length; ++i){
            for(int j = 0; j <= n; ++j){
                if (j >= squares[i-1]) dp[i][j] = Math.min(dp[i-1][j], dp[i][j-squares[i-1]] + 1);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[squares.length][n];
    }

    /*
    压缩
     */
    public int numSquares(int n) {
        int a = (int) Math.sqrt(n);
        if (a*a == n) return 1;
        int[] squares = getSquares(n);
        /*
        转化为凑成和为n的最短子集
        式子：f(i,j) = min(f(i-1, j), f(i, j-squares[i]) + 1)
        base case：f(0,0) = 0; f(0,i) = n+1;
        规模：i->squares.length; j->n
        填表顺序：一行一行填
         */
        int[] dp = new int[n+1];
        Arrays.fill(dp,n);
        dp[0] = 0;
        for(int i = 1;i <= squares.length; ++i){
            for(int j = squares[i-1]; j <= n; ++j){
                dp[j] = Math.min(dp[j], dp[j-squares[i-1]] + 1);
            }
        }
        return dp[n];
    }

    public int[] getSquares(int n){
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<=n; ++i){
            int a = (int) Math.sqrt(i);
            if (a*a == i) list.add(i);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); ++i){
            res[i] = list.get(i);
        }
        return res;
    }


}
