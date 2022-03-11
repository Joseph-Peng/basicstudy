package offer;

import java.util.Arrays;

public class Offer60_n个骰子的点数 {

    public double[] dicesProbability(int n) {
        /**
         * n个骰子可能出现的点数种类为6*n-n+1
         * 只有1个骰子的时候1，2，3，4，5，6都是1/6;
         * 当n=2时，有两个骰子
         * 计算1+1、1+2、1+3、1+4、1+5、1+6
         * 2+1、2+2、2+3、2+4、2+5、2+6
         * .....
         * 6+1、6+2、6+3、6+4、6+5、6+6
         * 这样就可以通过n-1的情况推出n个骰子的情况
         */
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            // 相当于把dp中所有的值都进行一次+1到+6
            for (int j = 0; j < dp.length; j++) {
                for (int k = 1; k <= 6; k++) {// 模拟+1+2+3+4+5+6
                    //减一是因为数组下标从0开始
                    // 例如只有两个骰子的时候temp[0]就是骰子点数为2的概率
                    temp[j + k - 1] += dp[j] * (1.0 / 6.0);
                }
            }
            dp = temp;
        }
        return dp;
    }

}
