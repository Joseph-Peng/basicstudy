package lc000to050;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LC47_全排列2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backTrace(nums,0,res,path);
        return res;
    }

    private void backTrace(int[] nums, int depth,List<List<Integer>> res, LinkedList<Integer> path) {
        if (depth == nums.length){
            res.add(new LinkedList<>(path));
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = depth; i < nums.length;++i){
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums,i,depth);
            path.add(nums[depth]);
            backTrace(nums,depth+1,res,path);
            path.removeLast();
            swap(nums,i,depth);
        }
    }

    public void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
