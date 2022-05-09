package lc451to500;

public class LC474_一和零 {

    /*
    式子：f(i,j,k) = Math.max(f(i-1,j,k), f(i-1, j-zeros[i], k-ones[i]) + 1)
    base case：f(0,0,0) = 0
    规模：i -> strs.length ;  j->m;  k->n;
    填表顺序：三维，从小到大遍历i
     */
    public int findMaxForm(String[] strs, int m, int n) {

        int[] zeros = new int[strs.length];
        int[] ones = new int[strs.length];
        for (int i = 0; i < strs.length; ++i){
            zeros[i] = getDigitCount(strs[i], '0');
            ones[i] = getDigitCount(strs[i], '1');
        }

        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= strs.length; ++i) {
            for (int j = m; j >= zeros[i - 1]; --j) {
                for (int k = n; k >= ones[i - 1]; --k) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros[i - 1]][k - ones[i - 1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int getDigitCount(String s, char target){
        int sum = 0;
        for(int i = 0; i < s.length(); ++i){
            if (s.charAt(i) == target) sum++;
        }
        return sum;
    }

}
