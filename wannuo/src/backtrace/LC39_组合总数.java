package backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC39_组合总数 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(0, 0, new LinkedList<>(), candidates, target);
        return res;
    }

    public void backtrace(int index, int sum, List<Integer> path, int[] candidates, int target) {
        if (sum >= target) {
            if (sum == target) res.add(new LinkedList<>(path));
            return;
        }
        if (index >= candidates.length) return;
        backtrace(index + 1, sum, path, candidates, target);
        path.add(candidates[index]);
        backtrace(index, sum + candidates[index], path, candidates, target);
        path.remove(path.size() - 1);
    }
}
