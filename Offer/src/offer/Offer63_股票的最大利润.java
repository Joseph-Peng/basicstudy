package offer;

public class Offer63_股票的最大利润 {

    public int maxProfit(int[] prices) {
        if (prices==null || prices.length == 0) return 0;
        int p = 0, min = prices[0];
        for (int i = 0; i<prices.length;++i){
            if (prices[i]<min) min = prices[i];
            p = Math.max(p,prices[i]-min);
        }
        return p;

    }
}
