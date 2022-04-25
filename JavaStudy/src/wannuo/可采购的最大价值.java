package wannuo;

import java.util.Scanner;

public class 可采购的最大价值 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int budget = sc.nextInt();
        int n = sc.nextInt();
        int[] pn = new int[n]; // 物资价格
        int[] wn = new int[n]; // 使用价格
        for(int i = 0; i<n;++i){
            pn[i] = sc.nextInt();
            wn[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][budget+1];
        for(int i = 1; i<=n ;++i){
            for(int j = 1; j<=budget;++j){
                if(pn[i-1] > j){ // 当前商品价格大于预算值，不能选
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // 取选当前商品和不选当前商品的最大值
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - pn[i-1]] + wn[i-1]);
                }
            }
        }
        System.out.println(dp[n][budget]);
    }
}
