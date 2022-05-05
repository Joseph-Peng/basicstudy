package lc351to400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC397_整数替换 {

    public int integerReplacement(int n) {
        map.put(1,0);
        return dfs(n);
    }

    Map<Integer, Integer> map = new HashMap<>();
    // 参数： n
    private int dfs(int n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int ans = 0;
        if (n%2 == 0){
            ans = dfs(n/2);
        }else {
            ans = Math.min(dfs(n/2), dfs(n/2 + 1));
        }
        map.put(n,ans);
        return ans;
    }
}
