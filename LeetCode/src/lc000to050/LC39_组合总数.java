package lc000to050;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC39_组合总数 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        LinkedList<Integer> path = new LinkedList<Integer>();
        backTrace(path,candidates,target,0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public void backTrace(LinkedList<Integer> path, int[] candidates, int target, int depth){
        if(target<0) return;
        if(target == 0){
            res.add(new LinkedList<Integer>(path));
            return;
        }

        for(int i = depth; i<candidates.length; ++i){
            if(target - candidates[i]>=0){
                path.add(candidates[i]);
                backTrace(path,candidates,target-candidates[i],i);
                path.removeLast();
            }
        }

    }
}
