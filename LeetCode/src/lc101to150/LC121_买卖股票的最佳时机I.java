package lc101to150;

public class LC121_买卖股票的最佳时机I {

    public int maxProfit(int[] prices){
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i = 1; i<prices.length;++i){
            maxProfit = Math.max(prices[i]-minPrice,maxProfit);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return maxProfit;
    }
}
