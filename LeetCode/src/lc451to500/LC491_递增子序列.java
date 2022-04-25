package lc451to500;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LC491_递增子序列 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrace(0,new LinkedList<>(),nums);
        return res;
    }

    List<List<Integer>> res = new LinkedList<>();

    // 参数: idx, path
    public void backtrace(int idx, LinkedList<Integer> path, int[] nums){
        // 出口
        if (path.size()>=2){
            res.add(new LinkedList<>(path));
        }
        if (idx >= nums.length) return;

        HashSet<Integer> set = new HashSet<>();
        for(int i = idx; i<nums.length; ++i){
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            if (path.size() == 0){
                path.add(nums[i]);
                backtrace(i+1,path,nums);
                path.removeLast();
            }else {
                if (path.getLast()<=nums[i]){
                    path.add(nums[i]);
                    backtrace(i+1,path,nums);
                    path.removeLast();
                }
            }

        }
    }
}
