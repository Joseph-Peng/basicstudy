package backtrace.review;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC39_组合总数 {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(0,0, new LinkedList<Integer>(), candidates, target);
        return res;
    }

    // 参数：idx，path
    public void backtrace(int idx, int sum, LinkedList<Integer> path, int[] candidates, int target){
        if (sum == target) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; ++i){
            if (sum + candidates[i] > target) return;
            path.add(candidates[i]);
            backtrace(i, sum + candidates[i], path, candidates, target);
            path.removeLast();
        }
    }


    // 参数：idx，path
    public void backtrace1(int idx, int sum, LinkedList<Integer> path, int[] candidates, int target){
        if (idx >= candidates.length || sum >= target){
            if (sum == target) res.add(new LinkedList<>(path));
            return;
        }
        // 不选
        backtrace(idx + 1, sum, path, candidates, target);
        // 选
        path.add(candidates[idx]);
        backtrace(idx, sum + candidates[idx], path, candidates, target);
        path.removeLast();
    }
}
