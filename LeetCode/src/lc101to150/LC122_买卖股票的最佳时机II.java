package lc101to150;

public class LC122_买卖股票的最佳时机II {

    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int dp0 = 0;
        int dp1 = -prices[0];
        for(int i = 1; i<prices.length;++i){
            dp0 = Math.max(dp0, dp1+prices[i]);
            dp1 = Math.max(dp1, dp0-prices[i]);
        }
        return dp0;

    }

    // 贪心
    // 由于没有限制,将所有上坡的值相加即可
    public int maxProfit1(int[] prices) {
        int ans = 0;
        for(int i = 1; i<prices.length;++i){
            if (prices[i]>prices[i-1]){
                ans += prices[i] - prices[i-1];
            }
        }
        return ans;
    }
}
