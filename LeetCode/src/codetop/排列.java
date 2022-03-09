package codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 排列 {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(permute(nums));
        System.out.println(permute1(nums));
    }

    // 全排列
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new LinkedList<Integer>();
        backTrace(nums, 0, nums.length, res, path);
        return res;
    }

    private static void backTrace(int[] nums, int depth, int len, List<List<Integer>> res, List<Integer> path) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = depth; i < len; i++) {
            swap(nums, i, depth);
            path.add(nums[depth]);
            backTrace(nums, depth + 1, len, res, path);
            path.remove(path.size() - 1);
            swap(nums, i, depth);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // 第二种排列

    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        backTrace(nums, 0, nums.length, path, res, visited);
        return res;
    }

    public static void backTrace(int[] nums, int depth, int len, List<Integer> path, List<List<Integer>> res, boolean[] visited) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                //swap(nums, i, depth);
                path.add(nums[i]);
                visited[i] = true;
                backTrace(nums, depth + 1, len, path, res, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
                //swap(nums, i, depth);
            }
        }
    }
}
