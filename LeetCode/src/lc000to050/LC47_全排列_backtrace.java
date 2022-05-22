package lc000to050;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LC47_全排列_backtrace {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        backtrace(new LinkedList<Integer>(), new boolean[nums.length], nums);
        return res;
    }

    static List<List<Integer>> res = new LinkedList<>();
    public static void backtrace(LinkedList<Integer> path, boolean[] visited,int[] nums){
        if(path.size() == nums.length){
            res.add(new LinkedList<>(path));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; ++i){
           // System.out.println(set.contains(nums[i]));
            if(set.contains(nums[i])) {
                System.out.println(set);
                continue;
            }

            if(!visited[i]){
                set.add(nums[i]);
                path.add(nums[i]);
                visited[i] = true;
                backtrace(path, visited, nums);
                visited[i] = false;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
}
