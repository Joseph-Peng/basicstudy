package lc101to150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC139_单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        memory = new int[s.length()];
        Arrays.fill(memory,-1);
        return dfs(0,s,wordSet);
    }

    int[] memory;

    // 参数 ： idx
    public boolean dfs(int idx,String s, HashSet<String> wordSet){
        // 出口
        if (idx == s.length()){
            return true;
        }

        if (memory[idx] != -1) return memory[idx] == 1;
        boolean ans = false;
        for (int i = idx; i<s.length() && !ans; ++i){
            if (wordSet.contains(s.substring(idx, i+1))){
                ans = dfs(i+1,s,wordSet);
            }
        }
        memory[idx] = ans ? 1 : 0;
        return ans;
    }

    // dp
    public boolean wordBreak1(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        // dp[i]表示前i个字符是否能被拆分为wordDict中的单词
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i <= s.length(); ++i){
            for (int j = 0; j<i;++j){
                if (dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
