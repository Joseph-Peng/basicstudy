package lc000to050;

import java.util.*;

public class LC40_组合总和II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        backTrace(candidates, target, res, path, 0);
        return res;
    }

    private void backTrace(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> path, int depth) {
        if (target < 0 || depth>candidates.length) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = depth; i < candidates.length; ++i) {
            if (i > depth && candidates[i] == candidates[i - 1]) continue;

            path.add(candidates[i]);
            backTrace(candidates, target - candidates[i], res, path, i + 1);
            path.removeLast();

        }
    }

    private void backTrace2(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> path, int depth) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = depth; i < candidates.length; ++i) {
            if (target < candidates[i]) break;
            if (i > depth && candidates[i] == candidates[i - 1]) continue;

            path.add(candidates[i]);
            backTrace(candidates, target - candidates[i], res, path, i + 1);
            path.removeLast();

        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{ 2,1, 2, 2, 5};
        int target = 5;
        LC40_组合总和II solution = new LC40_组合总和II();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);

    }
}
