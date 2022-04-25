package lc051_100;

import java.util.LinkedList;
import java.util.List;

public class LC77_组合 {

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, new LinkedList<>(), n, k);
        return res;
    }

    List<List<Integer>> res = new LinkedList<>();

    // 参数 当前遍历到哪一个数、path
    public void dfs(int idx, List<Integer> path, int n, int k) {
        // 出口
        if (path.size() == k || idx > n) {
            if (path.size() == k) res.add(new LinkedList<>(path));
            return;
        }

        // 状态转移
        for (int i = idx; i <= n; ++i) {
            // 剪枝，如果剩余元素+path里的元素小于k个，就return
            if (n-i+1+path.size() < k) return;
            path.add(i);
            dfs(i+1, path,n,k);
            path.remove(path.size() - 1);
        }
    }
}
