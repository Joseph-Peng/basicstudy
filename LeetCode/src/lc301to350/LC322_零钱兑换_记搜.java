package lc301to350;

import java.util.Arrays;

public class LC322_零钱兑换_记搜 {

    int[] memory;
    public int coinChange(int[] coins, int amount) {
        memory = new int[amount + 1];
        Arrays.fill(memory, -1);
        int ans = dfs(amount,coins);
        return ans == 10001 ? -1 : ans;
    }

    public int dfs(int amount, int[] coins){
        if (amount <= 0) {
            if (amount == 0) return 0;
            return 10001;
        }
        if (memory[amount] != -1) return memory[amount];
        int ans = 10001;
        for(int coin : coins){
            ans = Math.min(dfs(amount-coin, coins) + 1,ans);
        }
        memory[amount] = ans;
        return ans;
    }



}
