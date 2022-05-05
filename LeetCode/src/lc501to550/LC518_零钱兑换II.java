package lc501to550;

import java.util.Arrays;

public class LC518_零钱兑换II {

    public int change(int amount, int[] coins) {
        memory = new int[coins.length][amount+1];
        for (int i = 0; i<coins.length; ++i){
            Arrays.fill(memory[i], -1);
        }
        return dfs(0,amount,coins);
    }

    int memory[][];
    public int dfs(int idx, int amount, int[] coins){
        if (amount <= 0){
            if (amount == 0) return 1;
            return 0;
        }
        if (memory[idx][amount] != -1) return memory[idx][amount];
        int ans = 0;
        for(int i = idx; i<coins.length; ++i){
            ans += dfs(i,amount-coins[i], coins);
        }

        memory[idx][amount] = ans;
        return ans;
    }


}
