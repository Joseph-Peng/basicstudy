package codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 排列_长度为k的排列 {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(permuteK(nums,2));
        System.out.println(permute1(nums,2));
    }

    // k排列
    public static List<List<Integer>> permuteK(int[] nums,int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new LinkedList<Integer>();
        backTrace(nums, 0, k, res, path);
        return res;
    }

    private static void backTrace(int[] nums, int depth, int k, List<List<Integer>> res, List<Integer> path) {
        if (depth == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = depth; i < nums.length; i++) {
            swap(nums, i, depth);
            path.add(nums[depth]);
            backTrace(nums, depth + 1, k, res, path);
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

    public static List<List<Integer>> permute1(int[] nums,int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        backTrace(nums, 0, k, path, res, visited);
        return res;
    }

    public static void backTrace(int[] nums, int depth, int k, List<Integer> path, List<List<Integer>> res, boolean[] visited) {
        if (depth == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                backTrace(nums, depth + 1, k, path, res, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
